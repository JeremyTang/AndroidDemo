package com.mm.layout.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.util.Log;

public class FileUtil {

	public static File[] findFileByPath(String path) {
		//
		Log.d("file", "path = " + path);
		File rootFile = new File(path);
		if (rootFile.exists()) {
			if (rootFile.isDirectory()) {
				if (!rootFile.isHidden()) {
					return rootFile.listFiles();
				}

			}
		}
		return null;
	}

	public static String getTimeFormat(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD \t HH:mm:SS");
		return sdf.format(new Date(time));
	}

	public static void openFile(String filePaht) {
		File rootFile = new File(filePaht);
		if (rootFile.exists()) {
			if (!rootFile.isDirectory()) {
				// /////////////打开文件
			}
		}
	}

}
