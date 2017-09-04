package cn.studyjams.s2.sj0147.huangkai.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.studyjams.s2.sj0147.huangkai.R;
import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;
import cn.studyjams.s2.sj0147.huangkai.fragment.fragment3;

import static android.R.attr.data;
import static android.R.attr.name;

public class adapter extends ArrayAdapter<SendeMsg> {
	private LayoutInflater minflater;
	private int resourceId;
	private LinearLayout lin;

	public adapter(Context context, int textViewResourceId,
			List<SendeMsg> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SendeMsg sendeMsg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			lin = (LinearLayout) view.findViewById(R.id.id_layout_f2_lin);
			viewHolder.msg = (TextView) view.findViewById(R.id.id_tv_msg);
            viewHolder.fes = (TextView) view.findViewById(R.id.id_tv_fes);
            viewHolder.data = (TextView) view.findViewById(R.id.id_tv_date);

			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		fragment3 f = new fragment3();
		viewHolder.msg.setText(sendeMsg.getMsg());
       viewHolder.data.setText(sendeMsg.getDate());
        viewHolder.fes.setText(sendeMsg.getFestivalName());
		//把以前的添加进lin的view清除
		lin.removeAllViews();
		for (String name : sendeMsg.getNames().split(":")) {
			addtag(viewHolder,name);
		}

		return view;
	}



//	public String getdata() {
//		SendeMsg s =new SendeMsg();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm");
//		return df.format(s.getDate());
//	}

	class ViewHolder {

		TextView msg,fes,data,nametv;

	}
	//增加 收件人view
	private void addtag(ViewHolder viewHolder,String name ) {
		viewHolder.nametv = (TextView) fragment3.minflater.inflate(R.layout.tag,lin,false);
		viewHolder.nametv.setText(name);
		lin.addView(viewHolder.nametv);

	}

}
