package com.mm.layout.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ShortcutBroadcastReceiver extends BroadcastReceiver {

	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("com.intel.filemanager.shortcut")) {
			Log.d("tang", "doShortcut()");
		}
	}

}
