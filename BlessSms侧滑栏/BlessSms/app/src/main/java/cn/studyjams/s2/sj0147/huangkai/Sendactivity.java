package cn.studyjams.s2.sj0147.huangkai;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.zip.Inflater;

import cn.studyjams.s2.sj0147.huangkai.bean.Festival;
import cn.studyjams.s2.sj0147.huangkai.bean.Festivaldatas;
import cn.studyjams.s2.sj0147.huangkai.bean.Msg;
import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;
import cn.studyjams.s2.sj0147.huangkai.biz.Smsbiz;

import static android.R.attr.name;

public class Sendactivity extends AppCompatActivity {
    private int mfestivalId;
    private int msgId;
    private static  final  String KEY_FESTIVALID = "key";
    private static  final  String KEY_MSGID = "key2";
    private static  final  int CODE_REQUEST = 1;
    private Festival mFestival;
    private Msg mMsg;
    private EditText mEt;
    private Button mBt;
    private FloatingActionButton mFloatBt;
    private View mlayoutLoading;
    private LinearLayout mlayoutlin;
    private HashSet<String> mName = new HashSet<>();
    private HashSet<String> mNumber = new HashSet<>();
    private LayoutInflater mInflater;
//    private static final String ACTION_SEND_MSG = "ACTION_SEND_MSG";
//    private static final String ACTION_DELIVER_MSG = "ACTION_DELIVER__MSG";
    private PendingIntent msendPi;
    private PendingIntent mdeliverPi;
    private BroadcastReceiver mSendBroadcastReceiver;//广播接收器
    private BroadcastReceiver mDeliverBroadcastReceiver;
    private Smsbiz mSmBiz;//获得业务层对象
    private int mMsgSendCount;
    private int mTotalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sendactivity);
        mSmBiz = new Smsbiz(this);
        initData();//得到节日信息的数据
        initView();//初始化控件 设置文本框的值  信息内容
        initEvents();//事件
        initRecivers();//广播接收

        //设置软键盘自动弹出

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);


    }

    private void initRecivers() {
        Intent sendItent = new Intent("ACTION_SEND_MSG");
        msendPi = PendingIntent.getBroadcast(this,0,sendItent,0 );
        Intent deliverItent = new Intent("ACTION_DELIVER__MSG");
        mdeliverPi = PendingIntent.getBroadcast(this,0,deliverItent,0 );
//注册广播
        registerReceiver(mSendBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
//                if (getResultCode() == RESULT_OK){
//                    Log.e("info","短信发送成功"+(mMsgSendCount+"/"+mTotalCount));
//                }else {
//                    Log.e("info", "短信发送失败");
//                }
                mMsgSendCount++;
             Toast.makeText(Sendactivity.this,(mMsgSendCount+"/"+mTotalCount)+"短信发送成功",
                       Toast.LENGTH_SHORT).show();

                if (mMsgSendCount == mTotalCount){
                    finish();
                }
            }
        },new IntentFilter("ACTION_SEND_MSG"));

        registerReceiver(mDeliverBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("info","联系人已经成功接收到短信");
            }
        },new IntentFilter("ACTION_DELIVER__MSG"));
    }
//关闭广播接收器
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mSendBroadcastReceiver);
        unregisterReceiver(mDeliverBroadcastReceiver);
    }



    private void initEvents() {
        //添加联系人按钮
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,CODE_REQUEST);
            }
        });
        //发送按钮
        mFloatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNumber.size()==0){
                    Toast.makeText(Sendactivity.this,"请先选择联系人",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mEt.getText().toString())){
                    Toast.makeText(Sendactivity.this,"请输入短信内容",Toast.LENGTH_SHORT).show();
                    return;

                }
                mlayoutLoading.setVisibility(View.VISIBLE);
                //调用sendmsg发送短信
                mTotalCount=mSmBiz.sendMsg(mNumber,buildsendMsg(mEt.getText().toString()),msendPi,mdeliverPi);
//                mMsgSendCount=0;

            }
        });
        
        
    }

    //带回通讯录选中的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODE_REQUEST){
            //选了东西
            if (resultCode==RESULT_OK){
                Uri contactUri = data.getData();
                //拿到联系人等的信息
                Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex
                        (ContactsContract.Contacts.DISPLAY_NAME));

               String number = getNumber(cursor);
                if (!TextUtils.isEmpty(number)){
                    mNumber.add(number);
                    mName.add(name);
                }
               addtag(name,number);

            }
        }
    }

    public String getNumber(Cursor cursor) {
        //获得号码的数量
        int numberCount = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);

        String number = null;
        if (numberCount>0){
            //拿到联系人的id
            int contactId = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phonCursor = getContentResolver().query(ContactsContract.CommonDataKinds.
                    Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                    +"="+contactId,null,null);//只设置uri和查询条件
            phonCursor.moveToFirst();

            number =phonCursor.getString(phonCursor.getColumnIndex
                    (ContactsContract.CommonDataKinds.Phone.NUMBER));


            phonCursor.close();

        }
        cursor.close();

        return  number;
    }

    private void addtag(String name,String number) {
        //显示选中的人联系人名字
      TextView view = (TextView) mInflater.inflate(R.layout.tag,mlayoutlin,false);
        view.setText(name);
        mlayoutlin.addView(view);

    }


    private void initView() {
        mInflater =LayoutInflater.from(this);
        mEt= (EditText) findViewById(R.id.id_et_sen);
        mBt = (Button) findViewById(R.id.id_bt_sen);
        mFloatBt = (FloatingActionButton) findViewById(R.id.floatbutton);
        mlayoutLoading = findViewById(R.id.id_layout_loading);
        mlayoutlin = (LinearLayout) findViewById(R.id.id_layout_lin);

        mlayoutLoading.setVisibility(View.GONE);//设置发送转钮默认为不可见

        if (msgId != -1){
           mMsg = Festivaldatas.getInstance().getMsgByMsId(msgId);
            mEt.setText(mMsg.getContent());
            mFestival = Festivaldatas.getInstance().getFestivalByid(mfestivalId);
            setTitle(mFestival.getName());


        }


    }


    private SendeMsg buildsendMsg(String msg)
    {//吧信息保存下来 后面保存到数据库的时候用

        SendeMsg sendeMsg =new SendeMsg();
        sendeMsg.setMsg(msg);
        if (msgId != -1) {
            sendeMsg.setFestivalName(mFestival.getName());//得到节日的名字
        }
        //有多姓名 把分别取出来
        String names = "";
        for (String name : mName){
            names += name +":";//把那names分成 name:name:name....
        }
        sendeMsg.setNames(names.substring(0,names.length()-1));//删除最后一个:
//有多号码
        String numbers = "";
        for (String number : mNumber){
            numbers += number +":";
        }
        sendeMsg.setNumbers(numbers.substring(0,numbers.length()-1));//删除最后一个:
        return sendeMsg;
    }

    private void initData() {
        //得到传过来的数据
        mfestivalId = getIntent().getIntExtra(KEY_FESTIVALID,-1);
        msgId = getIntent().getIntExtra(KEY_MSGID,-1);


    }public static  void toActivity(Context context,int festivalId,int msgId){
        Intent intent = new Intent(context,Sendactivity.class);
        intent.putExtra(KEY_FESTIVALID,festivalId);
        intent.putExtra(KEY_MSGID,msgId);
        context.startActivity(intent);


    }


}

//查出本机全部号码姓名
//    Cursor cursor;
//		cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                null, null, null, null);
//                while (cursor.moveToNext()) {
//                String displayName = cursor.getString(cursor.getColumnIndex(
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                String number = cursor.getString(cursor.getColumnIndex(
//                ContactsContract.CommonDataKinds.Phone.NUMBER));
//                contactsList.add(displayName + number);