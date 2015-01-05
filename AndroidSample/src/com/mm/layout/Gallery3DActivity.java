package com.mm.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mm.layout.ui.CoverFlow;

@SuppressWarnings("deprecation")
public class Gallery3DActivity extends Activity {

	private CoverFlow mGallery;

	private int[] images;
	private ImageGalleryAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery3d);

		images = new int[] { R.drawable.image, R.drawable.image,
				R.drawable.image, R.drawable.image, R.drawable.image,
				R.drawable.image, R.drawable.image, R.drawable.image,
				R.drawable.image, R.drawable.image };

		mGallery = (CoverFlow) findViewById(R.id.coverflower);
		mAdapter = new ImageGalleryAdapter(this, images);
		mGallery.setAdapter(mAdapter);
		mGallery.setSelection(images.length / 2, true);
	}

	class ImageGalleryAdapter extends BaseAdapter {

		private Context mContext;
		private int[] resource;

		public ImageGalleryAdapter(Context context, int[] resource) {
			super();
			this.mContext = context;
			this.resource = resource;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return resource.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return resource[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			// ImageView imageView = createReflectedImages(mContext,
			// resource[arg0]);
			ImageView imageView = new ImageView(mContext);
			imageView.setLayoutParams(new CoverFlow.LayoutParams(120, 100));
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setPadding(imageView.getPaddingLeft() + 15,
					imageView.getPaddingTop(),
					imageView.getPaddingRight() + 15,
					imageView.getPaddingBottom());
			// BitmapDrawable drawable = (BitmapDrawable)
			// imageView.getDrawable();
			// drawable.setAntiAlias(true);
			imageView.setBackgroundResource(resource[arg0]);
			return imageView;
		}

		public float getScale(boolean focused, int offset) {
			return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
		}

		public ImageView createReflectedImages(Context mContext, int imageId) {
			Bitmap originalImage = BitmapFactory.decodeResource(
					mContext.getResources(), imageId);
			final int reflectionGap = 4;
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();

			Matrix matrix = new Matrix();
			matrix.preScale(1, -1);

			Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
					height / 2, width, height / 2, matrix, false);

			Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
					(height + height / 2), Config.ARGB_8888);

			Canvas canvas = new Canvas(bitmapWithReflection);
			canvas.drawBitmap(originalImage, 0, 0, null);

			Paint deafaultPaint = new Paint();
			canvas.drawRect(0, height, width, height + reflectionGap,
					deafaultPaint);
			canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

			Paint paint = new Paint();
			LinearGradient shader = new LinearGradient(0,
					originalImage.getHeight(), 0,
					bitmapWithReflection.getHeight() + reflectionGap,
					0x70ffffff, 0x00ffffff, TileMode.MIRROR);

			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
			canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
					+ reflectionGap, paint);

			ImageView imageView = new ImageView(mContext);
			imageView.setImageBitmap(bitmapWithReflection);

			return imageView;
		}

	}
}
