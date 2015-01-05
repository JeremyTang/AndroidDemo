package com.mm.layout.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * @author tjl
 * @category custom circle progress
 */
public class CustomProgress extends View {

	private int mProgrss;
	private int maxProgress;
	private int mStrokeWidth;

	private Rect mCircleRect;
	private Paint mPaint;

	private int mBgColor = Color.WHITE;
	private int mProgressColor = Color.RED;

	public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		init();
	}

	public CustomProgress(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public CustomProgress(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		mPaint = new Paint();
		mCircleRect = new Rect();
	}

	public void setBackgroundColor(int color) {
		this.mBgColor = color;
	}

	public void setProgressColor(int color) {
		this.mProgressColor = color;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		// 画背景空心圆
		mPaint.setColor(mBgColor);
		// 画进度

		super.onDraw(canvas);
	}

	interface OnProgressChangeListener {
		void onProgressChange(int progress, int max);
	}
}
