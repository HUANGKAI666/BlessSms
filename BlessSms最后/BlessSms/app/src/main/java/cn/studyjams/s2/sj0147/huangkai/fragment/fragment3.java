package cn.studyjams.s2.sj0147.huangkai.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;


import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.studyjams.s2.sj0147.huangkai.MainActivity;
import cn.studyjams.s2.sj0147.huangkai.R;
import cn.studyjams.s2.sj0147.huangkai.View.adapter;
import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;
import cn.studyjams.s2.sj0147.huangkai.db.SmsProvider;

import static cn.studyjams.s2.sj0147.huangkai.MainActivity.floatButton;


public class fragment3 extends Fragment{
	public static LayoutInflater minflater;
	private ListView mlistView;
	private LinearLayout lin;
	private AlertDialog.Builder alertDialog;
	private SendeMsg s;
	//	private   int id;
	boolean f = false;
	 static  Cursor cursor;


	private adapter marrayAdapter;

//	List<String> ids = new ArrayList<String>();



	List<SendeMsg> list2 = new ArrayList<SendeMsg>();


	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.f3, container, false);

	}



	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		minflater = LayoutInflater.from(getActivity());
		loaderData();
		mlistView  = (ListView) getActivity().findViewById(R.id.listview2);
		lin = (LinearLayout) getActivity().findViewById(R.id.id_layout_f2_lin);



	}


	private void loaderData() {
		getLoaderManager().initLoader(1, null, new
				LoaderManager.LoaderCallbacks<Cursor>() {
					@Override
					public Loader<Cursor> onCreateLoader(int id, Bundle args) {
						CursorLoader cursorLoader = new CursorLoader(getActivity(),
								SmsProvider.URI_SMS_ALL,null
								,null,null,null);

						return cursorLoader;
					}

					@Override
			public void onLoadFinished(Loader<Cursor> loader, final Cursor data) {//异步加载完成时得到数据
					//清除先前list中的数据 保证不重复
//					list2.clear();
					list2.removeAll(list2);
					final List<HashMap<String,Object>> ids =new ArrayList<HashMap<String,Object>>();

					//得到数据
					if (loader.getId() == 1) {
						while (data.moveToNext()) {
							String msg = data.getString(data.
										getColumnIndex(SendeMsg.COLUMU_MSG));
								String date = data.getString(data.
										getColumnIndex(SendeMsg.COLUMU_DATE));
								String fes = data.getString(data.
										getColumnIndex(SendeMsg.COLUMU_FESTIVALNAME));
								String names = data.getString(data.
										getColumnIndex(SendeMsg.COLUMU_NAMES));
								String id = data.getString(0);


//							for (int i=0;i<data.getColumnCount();i++){
//									map.put("_id",data.getString(0));
//                        map.put(SendeMsg.COLUMU_DATE,data.getString(1));
//                        map.put(SendeMsg.COLUMU_FESTIVALNAME,data.getString(2));
//                        map.put(SendeMsg.COLUMU_MSG,data.getString(3));
//                        map.put(SendeMsg.COLUMU_NAMES,data.getString(4));
//							}
//								ids.add(map);
//					for (int i=0;i<data.getColumnCount();i++){
//						ids.add(data.getString(0));
//					}
								//使用adapter来加载记录页面
								//添加值  adapter中使用
								s = new SendeMsg();
								s.setMsg(msg);
								s.setFestivalName(fes);
								s.setNames(names);
								s.setDate(date);
//		Toast.makeText(getActivity(),ids.size(),Toast.LENGTH_SHORT).show();
								list2.add(s);

//			Toast.makeText(getActivity(),id+"  ",Toast.LENGTH_SHORT).show();
								HashMap<String, Object> map = new HashMap<String, Object>();
								map.put("_id", id);
								ids.add(map);
					}
						}

						marrayAdapter = new adapter
								(getActivity(), R.layout.f2itme, list2);
						mlistView.setAdapter(marrayAdapter);
//						mlistView.setSelection(list2.size());//到达底部
						mlistView.requestLayout();
						marrayAdapter.notifyDataSetChanged();

				mlistView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
					@Override
					public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
						//							HashMap<String,Object> map2 = ids.get(position);
						alertDialog = new AlertDialog.Builder(getActivity());
						alertDialog.setIcon(R.mipmap.ic_warning_grey600_18dp);
						alertDialog.setTitle("删除记录！");
						alertDialog.setMessage("确认要删除吗？");
						alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								int idd = Integer.valueOf(ids.get(position).get("_id").toString());

								String where = "_id = ?";
								String[] selectionArs = new String[]{String.valueOf(idd)};
								getContext().getContentResolver().delete(SmsProvider.URI_SMS_ALL, where,
										selectionArs);

								//因为不自动更新 所以使用rome把它的listview界面先移除
								list2.remove(position);

								mlistView.requestLayout();
								marrayAdapter.notifyDataSetChanged();
							}
						});
						alertDialog.setNegativeButton("取消",null);
////        alertDialog.setMultiChoiceItems(new  String[] {"选项1", "选项2", "选项3" , "选项4" },
////                null ,  null );
						alertDialog.show();

						return true;
					}
				});


			}
					@Override
					public void onLoaderReset(Loader<Cursor> loader) {

					}
				});






	}



}
