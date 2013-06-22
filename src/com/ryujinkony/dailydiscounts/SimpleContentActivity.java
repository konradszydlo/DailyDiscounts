package com.ryujinkony.dailydiscounts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class SimpleContentActivity extends SherlockFragmentActivity {

	private static final String TAG = "SimpleContentActivity";
	
	public static final String EXTRA_FILE = "file";

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Log.i(TAG, "inside SimpleContentActivity.onCreate");
		
		if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
			String file = getIntent().getStringExtra("EXTRA_FILE");
			Fragment fragment = SimpleContentFragment.newInstance(file);
			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, fragment).commit();
		}
	}
}
