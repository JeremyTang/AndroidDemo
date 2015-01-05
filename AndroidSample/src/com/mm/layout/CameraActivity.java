package com.mm.layout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

public class CameraActivity extends Activity {

	private ImageView imageView;

	private Camera mCamera;
	private Bitmap mBit;

	private int centerX;
	private int centerY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		mBit = BitmapFactory.decodeResource(getResources(), R.drawable.image);
		imageView = (ImageView) findViewById(R.id.show_imageview);
		imageView.setImageBitmap(mBit);
		mCamera = new Camera();
		centerX = mBit.getWidth() / 2;
		centerY = mBit.getHeight() / 2;
		rotationView(0, 45, 0);
	}

	public void rotationView(float x, float y, float z) {
		mCamera.save();
		Matrix matrix = new Matrix();
		mCamera.rotate(x, y, z);
		mCamera.getMatrix(matrix);
		mCamera.restore();
		matrix.postTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
		mBit = Bitmap.createBitmap(mBit, 0, 0, mBit.getWidth(),
				mBit.getHeight(), matrix, true);
		imageView.setImageBitmap(mBit);
	}
}
