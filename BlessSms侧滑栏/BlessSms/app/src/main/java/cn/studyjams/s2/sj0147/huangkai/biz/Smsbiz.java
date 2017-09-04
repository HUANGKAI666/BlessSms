package cn.studyjams.s2.sj0147.huangkai.biz;

import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.telephony.SmsManager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;
import cn.studyjams.s2.sj0147.huangkai.db.SmsProvider;


//public class Smsbiz {
//
//    //返回短信条数
//    public int sendMsg(String number, String msg, PendingIntent sentPi, PendingIntent deliverPi) {
//        SmsManager smsManager = SmsManager.getDefault();
//        //分割短信内容
//        ArrayList<String> contents = smsManager.divideMessage(msg);
//        for (String content : contents) {
//            smsManager.sendTextMessage(number, null, content, sentPi, deliverPi);//发送短信
//
//        }
//        return contents.size();
//    }
//
//    //发送几个联系人时候
//    public int sendMsg(HashSet<String> numbers, String msg, PendingIntent sentPi, PendingIntent deliverPi) {
//        int result = 0;
////        SmsManager smsManager = SmsManager.getDefault();
//        for (String number : numbers) {
//            int count = sendMsg(number, msg, sentPi, deliverPi);
//            result += count;
//        }
//        return result;
//    }
//}
public class Smsbiz {
    //传入一个context
    private Context context;
    public static ArrayList<String> ids;
    public Smsbiz(Context context){

        this.context =context;
    }
    //返回短信条数
    public int  sendMsg(String number, String msg, PendingIntent sentPi,PendingIntent deliverPi){
        SmsManager smsManager = SmsManager.getDefault();
        //分割短信内容
        ArrayList<String> contents =  smsManager.divideMessage(msg);
        for (String content : contents){
            smsManager.sendTextMessage(number,null,content,sentPi,deliverPi);//发送短信

        }
        return contents.size();
    }
    //发送几个联系人时候
    public int  sendMsg(HashSet<String> numbers, SendeMsg msg, PendingIntent sentPi, PendingIntent deliverPi){
        save(msg);
        int result = 0;
        for (String number : numbers){
            int count =  sendMsg(number,msg.getMsg(),sentPi,deliverPi);
            result= count+result;
        }
        return result;
    }

    private  void  save(SendeMsg sendeMsg){
//        sendeMsg.setDate(new Date());

        ContentValues values = new ContentValues();//对ContentProvider中的数据进行操作
//        values.put(SendeMsg.COLUMU_DATE,sendeMsg.getDate().getTime());
        //把发送短信时间直接设置为当前时间 直接添加到数据库中
          values.put(SendeMsg.COLUMU_DATE,getdata());
        values.put(SendeMsg.COLUMU_FESTIVALNAME,sendeMsg.getFestivalName());
        values.put(SendeMsg.COLUMU_MSG ,sendeMsg.getMsg());
        values.put(SendeMsg.COLUMU_NAMES,sendeMsg.getNames());
        values.put(SendeMsg.COLUMU_NUMBERS,sendeMsg.getNumbers());
        Uri newuri = context.getContentResolver().insert(SmsProvider.URI_SMS_ALL,values);
        String newid = newuri.getPathSegments().get(1);
        ids = new ArrayList<String>();
        if (newid!=null){
         ids.add(newid);
        }
    }
    //时间date转换为string
    public String getdata() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm");
        return df.format(new Date());
    }



}








