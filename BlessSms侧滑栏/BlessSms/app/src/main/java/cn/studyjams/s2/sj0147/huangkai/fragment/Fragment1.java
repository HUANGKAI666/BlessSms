package cn.studyjams.s2.sj0147.huangkai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import cn.studyjams.s2.sj0147.huangkai.Activity_two;
import cn.studyjams.s2.sj0147.huangkai.R;
import cn.studyjams.s2.sj0147.huangkai.bean.Festival;
import cn.studyjams.s2.sj0147.huangkai.bean.Festivaldatas;

import static android.R.attr.key;
import static android.os.Build.ID;

public class Fragment1 extends Fragment {
    private GridView mgidview;
    private LayoutInflater minflater;
    private ArrayAdapter<Festival> madapter;
   public static final String key = "key";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_festival,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        minflater = LayoutInflater.from(getActivity());
        mgidview =(GridView) view.findViewById(R.id.gridView1);

        mgidview.setAdapter(madapter = new ArrayAdapter<Festival>(getActivity(),-1,
                Festivaldatas.getInstance().getFestivaldatas()){

            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
               if (convertView == null){
                   convertView = minflater.inflate(R.layout.f1itme,parent,false);
               }
              TextView tv = (TextView) convertView.findViewById(R.id.text_fragment);
                tv.setText(getItem(position).getName());
                return convertView;
            }
        });

       mgidview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(getActivity(), Activity_two.class);
               intent.putExtra(key,madapter.getItem(position).getId());//得到现在所选节日的id值
               startActivity(intent);
//                        Intent intent = new Intent(getActivity(),Activity_two.class);
//               intent.putExtra(key,madapter.getItem(position).getId());//得到现在所选节日的id值
//               startActivity(intent);
//              Toast.makeText(getActivity(),"dfdf",Toast.LENGTH_SHORT).show();
           }
       });


    }
}

