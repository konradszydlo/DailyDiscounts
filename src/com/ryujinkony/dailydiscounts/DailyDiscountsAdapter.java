package com.ryujinkony.dailydiscounts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class DailyDiscountsAdapter extends FragmentStatePagerAdapter {
	private DiscountsModel model = null;

	public DailyDiscountsAdapter(SherlockFragmentActivity ctxt, DiscountsModel model) {
		super(ctxt.getSupportFragmentManager());

		this.model = model;
	}

	@Override
	public Fragment getItem(int position) {
		String path = model.getDailyDiscountFile(position);

				return (SimpleContentFragment.newInstance("file:///android_asset/discounts/"
				+ path));
	}

	@Override
	public int getCount() {
		return (model.getDailyDiscountsCount());
	}
}
