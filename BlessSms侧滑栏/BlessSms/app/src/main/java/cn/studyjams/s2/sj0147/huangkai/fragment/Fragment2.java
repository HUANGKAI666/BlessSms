package cn.studyjams.s2.sj0147.huangkai.fragment;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import cn.studyjams.s2.sj0147.huangkai.R;
import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;
import cn.studyjams.s2.sj0147.huangkai.db.SmsProvider;


public class Fragment2 extends ListFragment{
    private LayoutInflater minflater;
    private CursorAdapter mcursorAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        minflater = LayoutInflater.from(getActivity());
        initLoader();
        setupListAdapter();


    }



    private void setupListAdapter() {
        mcursorAdapter = new CursorAdapter(getActivity(),null,false) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View view2 = minflater.inflate(R.layout.f2itme, parent, false);
                return view2;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
               LinearLayout lin = (LinearLayout) view.findViewById(R.id.id_layout_f2_lin);
                TextView tv_msg = (TextView) view.findViewById(R.id.id_tv_msg);
                TextView tv_fes = (TextView) view.findViewById(R.id.id_tv_fes);
                TextView tv_date = (TextView) view.findViewById(R.id.id_tv_date);
                tv_msg.setText(cursor.getString(cursor.getColumnIndex(SendeMsg.COLUMU_MSG)));
                tv_fes.setText(cursor.getString(cursor.getColumnIndex(SendeMsg.COLUMU_FESTIVALNAME)));
                tv_date.setText(cursor.getString(cursor.getColumnIndex(SendeMsg.COLUMU_DATE)));
                String names = cursor.getString(cursor.getColumnIndex(SendeMsg.COLUMU_NAMES));

                for (String name : names.split(":")) {
                    addtag(name, lin);
                }
            }

        };
        setListAdapter(mcursorAdapter);

    }

    private void addtag(String name ,LinearLayout lin) {
        TextView tv = (TextView) minflater.inflate(R.layout.tag,lin,false);
        tv.setText(name);
        lin.addView(tv);

    }
//异步的query的时候，我们就需要使用LoaderManager了。使用LoaderManager就可以在不阻塞UI主线程的情况下完成数据的加载。
    private void initLoader() {
        getLoaderManager().initLoader(1, null, new
                LoaderManager.LoaderCallbacks<Cursor>() {
                    @Override
     public Loader<Cursor> onCreateLoader(int id, Bundle args) {
           CursorLoader cursorLoader = new CursorLoader(getActivity(),
                   SmsProvider.URI_SMS_ALL
                   ,null,null,null,null);

                        return cursorLoader;
                    }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {//loader结束的时候
              if (loader.getId()==1) {
                  //得到异步加载数据，更新Adapter
        mcursorAdapter.swapCursor(data);

    }
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {//Cursor变化的时候
            mcursorAdapter.swapCursor(null);
            }
        });
    }

}
