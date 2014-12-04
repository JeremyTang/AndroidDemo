package com.main.floatwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class FloatLargerView extends FrameLayout {

	public FloatLargerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		onCreat();
	}

	public FloatLargerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		onCreat();
	}

	public FloatLargerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		onCreat();
	}

	private void onCreat() {
		LayoutInflater.from(getContext()).inflate(R.layout.float_larger, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		Log.d("tjl", "OntouEvent");
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:

			break;
		}
		return super.onTouchEvent(event);
	}
}
