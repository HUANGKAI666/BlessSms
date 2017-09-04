package cn.studyjams.s2.sj0147.huangkai;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;
import java.util.zip.Inflater;

import cn.studyjams.s2.sj0147.huangkai.bean.Festival;
import cn.studyjams.s2.sj0147.huangkai.bean.Festivaldatas;
import cn.studyjams.s2.sj0147.huangkai.bean.Msg;
import cn.studyjams.s2.sj0147.huangkai.fragment.Fragment1;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class Activity_two extends AppCompatActivity {
private ArrayAdapter<Msg> ladapter;
    private ListView listView;
    private LayoutInflater linflater;
    private FloatingActionButton floatButton;
    private int FestivalId;
    private Festival mFestival;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_two);
        FestivalId =getIntent().getIntExtra(Fragment1.key,-1);//接收节日界面传过来的节日id
        listView =(ListView)findViewById(R.id.listview);
        floatButton = (FloatingActionButton) findViewById(R.id.floatbutton1);
        linflater = LayoutInflater.from(this);
        mFestival = Festivaldatas.getInstance().getFestivalByid(FestivalId);
        setTitle(mFestival.getName());
        listView.setAdapter(ladapter = new ArrayAdapter<Msg>(this,R.layout.listview_itme,
                Festivaldatas.getInstance().getMsgsByFestivalId(FestivalId)){
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
              ViewHolder v = new ViewHolder();
               if (convertView ==null ) {
                   convertView =linflater.inflate(R.layout.listview_itme,parent,false);
                   v.tv = (TextView) convertView.findViewById(R.id.list_text);
                   v.bt = (Button) convertView.findViewById(R.id.list_bt);
                   convertView.setTag(v);
               }else {
                   v = (ViewHolder) convertView.getTag();
               }
//                List<Msg> s = Festivaldatas.getInstance().getMsgsByFestivalId(FestivalId);
//                Msg h = s.get(position);
//                v.tv.setText(h.getContent());
               v.tv.setText(getItem(position).getContent());

                v.bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//调用sendactivity中的方法  把得到的节日id信息id传过去
                    Sendactivity.toActivity(Activity_two.this,getItem(position).getFestvaId(),
                            getItem(position).getId());

                    }
                });

                return convertView;
            }
            class ViewHolder{
                TextView tv;
                Button bt;
            }


        });

        EeitBt();
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                           floatButton.setVisibility(View.GONE);
                        }else {
                            floatButton.setVisibility(View.VISIBLE);
                        }
                        break;
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int
                    totalItemCount) {

            }
        });


    }

    private void EeitBt() {
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    Sendactivity.toActivity(Activity_two.this,FestivalId,-1);


            }
        });
    }

}
