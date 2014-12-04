package com.main.floatwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class FloatSmallView extends FrameLayout {

	private float xInDown = 0;
	private float yInDown = 0;

	public FloatSmallView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		onCreate();
	}

	public FloatSmallView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		onCreate();
	}

	public FloatSmallView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		onCreate();
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		Log.e("tang", "SmallView finishinflater");
		super.onFinishInflate();
	}

	private void onCreate() {
		LayoutInflater.from(getContext()).inflate(R.layout.float_small, this);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		Log.d("tjl", "OntouEvent");
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			xInDown = event.getX();
			yInDown = event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			MyWindowManager.newInstance(getContext()).moveSmallView(
					(int) (event.getRawX() - xInDown),
					(int) (event.getRawY() - yInDown));
			break;
		case MotionEvent.ACTION_UP:
			MyWindowManager.newInstance(getContext()).positionSmallView(
					event.getRawX(), event.getRawY());
			Log.e("tang",
					"rawX = " + event.getRawX() + "---- rawY = "
							+ event.getRawY() + " ********* X = "
							+ event.getX() + " ---- Y =  " + event.getY());
			break;
		}
		return super.onTouchEvent(event);
	}

	private void openLargerView() {
		MyWindowManager.newInstance(getContext()).hideSmallView();
		MyWindowManager.newInstance(getContext()).showLargerView();
	}

}
