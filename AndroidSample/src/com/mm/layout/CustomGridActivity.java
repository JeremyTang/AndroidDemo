package com.mm.layout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.mm.layout.adapter.ExpandableGridAdapter;

public class CustomGridActivity extends Activity {

	private String[] files;
	private ExpandableListView mExpand;
	private ExpandableGridAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customgrid);
		init();
	}

	private void init() {
		mExpand = (ExpandableListView) findViewById(R.id.custom_gridview);
		files = getResources().getStringArray(R.array.app_name);
		mAdapter = new ExpandableGridAdapter(CustomGridActivity.this,
				getChild(files));
		mExpand.setAdapter(mAdapter);
	}

	public List<String[]> getChild(String[] strs) {
		List<String[]> arrays = new ArrayList<String[]>();
		for (String s : strs) {
			//String[] s = new 
		}
		return arrays;
	}

}
