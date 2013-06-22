package com.ryujinkony.dailydiscounts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract public class AbstractContentFragment extends WebViewFragment {

	abstract String getDiscountPage();

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setRetainInstance(true);
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle icicle) {
		View result = super.onCreateView(inflater, container, icicle);

		getWebView().getSettings().setJavaScriptEnabled(true);
		getWebView().getSettings().setSupportZoom(true);
		getWebView().getSettings().setBuiltInZoomControls(true);
		getWebView().loadUrl(getDiscountPage());

		return result;
	}

}
