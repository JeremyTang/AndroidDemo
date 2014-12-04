package com.main.floatwindow;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class MyWindowManager {

	private FloatSmallView mSmallView;
	private FloatLargerView mLargerView;

	private LayoutParams mSmallParams;
	private LayoutParams mLargerParams;

	private WindowManager wManager;
	private ActivityManager aManager;

	private int screenWidth;
	private int screenHeight;

	private static MyWindowManager mInstance = null;
	private Context mContext;

	public static MyWindowManager newInstance(Context context) {

		if (mInstance == null) {
			mInstance = new MyWindowManager(context);
		}

		return mInstance;

	}

	private MyWindowManager(Context context) {
		mContext = context;
		wManager = (WindowManager) context
				.getSystemService(context.WINDOW_SERVICE);
		screenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
		screenHeight = mContext.getResources().getDisplayMetrics().heightPixels;
	}

	public void createSmallView() {
		mSmallView = new FloatSmallView(mContext);
		mSmallView.setVisibility(View.GONE);
		mSmallParams = new LayoutParams();
		mSmallParams.type = LayoutParams.TYPE_PHONE;
		mSmallParams.format = PixelFormat.RGBA_8888;
		mSmallParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
				| LayoutParams.FLAG_NOT_FOCUSABLE;
		mSmallParams.gravity = Gravity.LEFT | Gravity.TOP;
		mSmallParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		mSmallParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		mSmallParams.x = 0;
		mSmallParams.y = screenHeight / 2;
		mSmallView.setLayoutParams(mSmallParams);
		wManager.addView(mSmallView, mSmallParams);
	}

	public void createLargerView() {
		mLargerView = new FloatLargerView(mContext);
		mLargerView.setVisibility(View.GONE);
		mLargerParams = new LayoutParams();
		mLargerParams.type = LayoutParams.TYPE_PHONE;
		mLargerParams.format = PixelFormat.RGBA_8888;
		mLargerParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
				| LayoutParams.FLAG_NOT_FOCUSABLE;
		mLargerParams.gravity = Gravity.LEFT | Gravity.TOP;
		mLargerParams.width = screenWidth / 4;
		mLargerParams.height = screenHeight / 4;
		mLargerParams.x = mSmallParams.x;
		mLargerParams.y = mSmallParams.y;
		mLargerView.setLayoutParams(mSmallParams);
		wManager.addView(mLargerView, mLargerParams);
	}

	public void showSmallView() {
		if (mSmallView == null) {
			createSmallView();
		}
		mSmallView.setVisibility(View.VISIBLE);
	}

	public void showLargerView() {
		if (mLargerView == null) {
			createLargerView();
		}
		mLargerView.setVisibility(View.VISIBLE);
	}

	public void hideSmallView() {
		if (mSmallView == null) {
			return;
		}
		mSmallView.setVisibility(View.GONE);
	}

	public void hideLargerView() {
		if (mLargerView == null) {
			return;
		}
		mLargerView.setVisibility(View.GONE);
	}

	// public void removeSmallView() {
	// if (mSmallView == null) {
	// return;
	// }
	// wManager.removeView(mSmallView);
	// }

	// public void removeLargerView() {
	// if (mLargerView == null) {
	// return;
	// }
	// wManager.removeView(mLargerView);
	// }

	public boolean isSmallShowing() {
		return mSmallView != null && mSmallView.isShown();
	}

	public boolean isLargerShowing() {
		return mLargerView != null && mLargerView.isShown();
	}

	public boolean isWindoShowing() {
		return isSmallShowing() || isLargerShowing();
	}

	public void moveSmallView(int x, int y) {
		mSmallParams.x = x;
		mSmallParams.y = y;
		wManager.updateViewLayout(mSmallView, mSmallParams);
	}

	public void positionSmallView(float x,float y) {
		mSmallParams.x = 0;
		int width = mContext.getResources().getDisplayMetrics().widthPixels;
		if(x>width/2){
			mSmallParams.x =  width - mSmallView.getWidth();
		}
		mSmallParams.y = (int)y;
		wManager.updateViewLayout(mSmallView, mSmallParams);
	}

}
