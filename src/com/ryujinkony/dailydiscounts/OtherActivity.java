package com.ryujinkony.dailydiscounts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class OtherActivity extends Activity{

	private static final String TAG = "OtherActivity";
	
	@Override 
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.other);
		
		Log.i(TAG, "inside OtherActivity.onCreate");
	}
}
