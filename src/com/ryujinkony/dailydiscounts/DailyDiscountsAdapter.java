package com.ryujinkony.dailydiscounts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class DailyDiscountsAdapter extends FragmentStatePagerAdapter {

	private DiscountsModel discounts = null;
	
	public DailyDiscountsAdapter(SherlockFragmentActivity ctxt, DiscountsModel discounts) {
		super(ctxt.getSupportFragmentManager());
		this.discounts = discounts;
	}
	
	@Override
	public Fragment getItem(int position) {
		String discountFile = discounts.getDailyDiscountFile(position);
		
		return (SimpleContentFragment.newInstance("file:///android_asset/discounts/" + discountFile));
	}
	
	@Override
	public int getCount() {
		return discounts.getDailyDiscountsCount();
	}
}
