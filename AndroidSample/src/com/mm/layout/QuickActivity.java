package com.mm.layout;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class QuickActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		if (isFirstRun()) {
			Intent shortcut = new Intent(
					"com.android.launcher.action.INSTALL_SHORTCUT");

			// 快捷方式的名称
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
					getString(R.string.app_name));
			// 不允许重复创建
			shortcut.putExtra("duplicate", false);

			// 指定当前的Activity为快捷方式启动的对象: 如 com.everest.video.VideoPlayer
			// 这里必须为Intent设置一个action，可以任意(但安装和卸载时该参数必须一致)
			// String action = "com.android.action.quick";
			Intent respondIntent = new Intent(this, this.getClass());
			// respondIntent.setAction(action);
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, respondIntent);
			// 快捷方式的图标
			ShortcutIconResource iconRes = Intent.ShortcutIconResource
					.fromContext(this, R.drawable.ic_launcher);
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

			sendBroadcast(shortcut);
		}
	}

	private boolean isFirstRun() {
		SharedPreferences mShared = getPreferences(MODE_PRIVATE);
		boolean isFirst = mShared.getBoolean("first", true);
		if (isFirst) {
			mShared.edit().putBoolean("first", false).commit();
		}
		return isFirst;
	}

}
