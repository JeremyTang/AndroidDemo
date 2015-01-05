package com.mm.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

import com.mm.layout.ui.DragFramLayout;
import com.mm.layout.ui.IconTextView;

public class DragActivity extends Activity implements OnLongClickListener {

	private DragFramLayout mDrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drag);
		mDrag = (DragFramLayout) findViewById(R.id.drag_main);
		mDrag.setOnLongClickListener(this);
	}

	@Override
	public boolean onLongClick(View view) {
		// TODO Auto-generated method stub
		Log.d("jing", "view == " + (view instanceof IconTextView) + " ------ "
				+ (view instanceof TextView));
		mDrag.startDragScorll(view);

		return true;
	}

}
