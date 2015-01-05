package com.hampoo.gatt;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class Main extends Activity {

	private static final int REQUEST_ENABLE_BT = 1;
	private static final int SCAN_DURATION = 30000;

	private ProgressBar circleProgress;
	private ListView mListView;
	private List<String> itemList;
	private static boolean isScan = false;

	private ArrayAdapter<String> mAdapter;

	private BluetoothAdapter mBtAdapter;
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {

			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		circleProgress = (ProgressBar) findViewById(R.id.progress_circular);
		mListView = (ListView) findViewById(R.id.device_listview);
		itemList = new ArrayList<String>();
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, itemList);
		mListView.setAdapter(mAdapter);
		initBluetooth();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu, menu);
		if (isScan) {
			menu.findItem(R.id.menu_scan).setVisible(false);
			menu.findItem(R.id.menu_stop).setVisible(true);
		} else {
			menu.findItem(R.id.menu_scan).setVisible(true);
			menu.findItem(R.id.menu_stop).setVisible(false);
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		scanLeDevice(!isScan);
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		scanLeDevice(false);
		super.onDestroy();
	}

	private void initBluetooth() {
		mBtAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBtAdapter == null) {
			return;
		}
		if (!mBtAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		} else {
			scanLeDevice(true);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			if (resultCode == Activity.RESULT_CANCELED) {
				finish();
				return;
			}
			scanLeDevice(true);
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void scanLeDevice(boolean enable) {
		if (enable) {
			// Stops scanning after a pre-defined scan period.
			mHandler.postDelayed(new Runnable() {
				@Override
				public void run() {
					scanLeDevice(false);
				}
			}, SCAN_DURATION);
			Log.e("tjl", "startScan");
			isScan = true;
			mBtAdapter.startLeScan(mLeScanCallback);
			circleProgress.setVisibility(View.VISIBLE);
		} else {
			isScan = false;
			mBtAdapter.stopLeScan(mLeScanCallback);
			circleProgress.setVisibility(View.GONE);
		}
		invalidateOptionsMenu();
	}

	private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
		public void onLeScan(BluetoothDevice arg0, int arg1, byte[] arg2) {
			// TODO Auto-generated method stub
			final BluetoothDevice device = arg0;
			runOnUiThread(new Runnable() {
				public void run() {
					String name = device.getName();
					if (name == null) {
						name = device.getAddress();
					}
					Log.e("tjl", "Device = " + name);
					mAdapter.add(name);
				}
			});

		}
	};
}
