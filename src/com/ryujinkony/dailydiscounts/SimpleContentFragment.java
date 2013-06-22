package com.ryujinkony.dailydiscounts;

import android.os.Bundle;
import android.util.Log;

public class SimpleContentFragment extends AbstractContentFragment {

	private static final String KEY_FILE = "file";
	
	private static final String TAG = "SimpleContentFragment";

	protected static SimpleContentFragment newInstance(String file) {
		SimpleContentFragment fragment = new SimpleContentFragment();

		Log.i(TAG, "inside SimpleContentFragment.newInstance");
		
		Bundle args = new Bundle();
		args.putString(KEY_FILE, file);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	String getDiscountPage() {
		return getArguments().getString(KEY_FILE);
	}
}
