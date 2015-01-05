package com.mm.layout.adapter;

import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.GridView;

import com.mm.layout.R;

public class ExpandableGridAdapter implements ExpandableListAdapter {

	private Context mContext;
	private List<String[]> parentList;
	private CustomGridApdater parentAdapter;

	public ExpandableGridAdapter(Context mContext, List<String[]> parentList) {
		super();
		this.mContext = mContext;
		this.parentList = parentList;
	}

	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View view,
			ViewGroup arg4) {
		ChildViewHolder holder = null;
		final int position = arg0;
		if (view == null) {
			holder = new ChildViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.add_layout,
					null);
			view.setTag(holder);
		} else {
			holder = (ChildViewHolder) view.getTag();
		}
		return view;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCombinedChildId(long arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCombinedGroupId(long arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View view, ViewGroup group) {
		// TODO Auto-generated method stub
		ParentViewHolder holder = null;
		final int position = arg0;
		if (view == null) {
			holder = new ParentViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.parent_grid,
					null);
			holder.mGirdView = (GridView) view
					.findViewById(R.id.parent_gridview);
			view.setTag(holder);
		} else {
			holder = (ParentViewHolder) view.getTag();
		}
		parentAdapter = new CustomGridApdater(mContext, parentList.get(arg0));
		holder.mGirdView.setAdapter(parentAdapter);
		holder.mGirdView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ExpandableGridAdapter.this.onGroupExpanded(position);
			}
		});
		return view;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onGroupCollapsed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGroupExpanded(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub

	}

	class ParentViewHolder {
		GridView mGirdView;
	}

	class ChildViewHolder {

	}

}
