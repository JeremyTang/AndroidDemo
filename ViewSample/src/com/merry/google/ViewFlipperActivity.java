package com.merry.google;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity {

	private ViewFlipper mViewFlipper;
	private GestureDetector mDetector;
	private ProgressBar mProgress;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {
				mProgress.setVisibility(View.GONE);
				mViewFlipper.removeAllViews();
				for (int i = 0; i < 5; i++) {
					ImageView imageView = new ImageView(
							ViewFlipperActivity.this);
					imageView.setLayoutParams(new LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
					imageView.setImageResource(R.drawable.dog5);
					mViewFlipper.addView(imageView);
				}
				mViewFlipper.setFlipInterval(3000);
				mViewFlipper.startFlipping();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewflipper);

		mViewFlipper = (ViewFlipper) findViewById(R.id.main_viewflipper);
		mDetector = new GestureDetector(this, new MyGestureListener());
		mViewFlipper.setOnTouchListener(new MyTouchListener());
		mProgress = (ProgressBar) findViewById(R.id.empty_progress);
		// mProgress.setVisibility(View.VISIBLE);
		// mViewFlipper.removeAllViews();
		// mViewFlipper.addView(mProgress);
		// mHandler.sendEmptyMessageDelayed(1, 3000);
	}

	class MyGestureListener implements OnGestureListener {

		@Override
		public boolean onDown(MotionEvent arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			// 右滑
			if (arg1.getX() > arg0.getX()) {
				mViewFlipper.setInAnimation(ViewFlipperActivity.this,
						R.anim.left_to_right_in);
				mViewFlipper.setOutAnimation(ViewFlipperActivity.this,
						R.anim.left_to_right_out);
				mViewFlipper.showPrevious();
			} else {
				mViewFlipper.setInAnimation(ViewFlipperActivity.this,
						R.anim.right_to_left_in);
				mViewFlipper.setOutAnimation(ViewFlipperActivity.this,
						R.anim.right_to_left_out);
				mViewFlipper.showNext();
			}
			return true;
		}

		@Override
		public void onLongPress(MotionEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onSingleTapUp(MotionEvent arg0) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	class MyTouchListener implements OnTouchListener {

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			mDetector.onTouchEvent(arg1);
			return true;
		}
	}

}
