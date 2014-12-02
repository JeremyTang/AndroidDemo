package com.main.floatwindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button openButton;
	private Button closeButton;

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		intent = new Intent(this, FloatWindowService.class);

		openButton = (Button) findViewById(R.id.open_window);
		openButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startService(intent);
				MainActivity.this.finish();
			}
		});

		closeButton = (Button) findViewById(R.id.close_window);
		closeButton.setVisibility(View.GONE);
		closeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
	}
}
