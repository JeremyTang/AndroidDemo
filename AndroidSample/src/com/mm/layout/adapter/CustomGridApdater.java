package com.mm.layout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mm.layout.R;

public class CustomGridApdater extends BaseAdapter {

	private Context mContext;
	private String[] files;

	public CustomGridApdater(Context mContext, String[] files) {
		super();
		this.mContext = mContext;
		this.files = files;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return files.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return files[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		String file = files[arg0];
		if (view == null) {
			holder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(
					R.layout.custom_grid_item, null);
			//holder.icon = (ImageView) view.findViewById(R.id.app_icon);
			holder.name = (TextView) view.findViewById(R.id.app_name);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		//holder.icon.setImageResource(R.drawable.portal_container_holo);
		holder.name.setText(file);
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				View view = LayoutInflater.from(mContext).inflate(
						R.layout.add_layout, null);
				ViewGroup v = (ViewGroup) arg0;
				v.addView(view);
			}
		});
		return view;
	}

	class ViewHolder {
		//ImageView icon;
		TextView name;
	}

}
