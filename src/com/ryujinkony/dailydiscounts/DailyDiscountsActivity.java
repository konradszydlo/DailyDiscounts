package com.ryujinkony.dailydiscounts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;



public class DailyDiscountsActivity extends SherlockFragmentActivity {

	private static final String TAG = "DailyDiscountsActivity";
	
	private static final String MODEL = "model";

	private ViewPager viewPager = null;
	private DailyDiscountsAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		Log.i(TAG, "inside DailyDiscountsActivity onCreate");
		
		if (getSupportFragmentManager().findFragmentByTag(MODEL) == null) {
			getSupportFragmentManager().beginTransaction()
					.add(new ModelFragment(), MODEL).commit();

		}
		setContentView(R.layout.main);

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.options, menu);
		
		Log.i(TAG, "menu created");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			viewPager.setCurrentItem(0, false);
			return (true);

		case R.id.about:
			Log.i(TAG, "about clicked");
			Intent i = new Intent(this, SimpleContentActivity.class);

			i.putExtra(SimpleContentActivity.EXTRA_FILE,
					"file:///android_asset/misc/about.html");
			startActivity(i);

			return (true);

		case R.id.help:
			Log.i(TAG, "help clicked");
//			i = new Intent(this, SimpleContentActivity.class);
//			i.putExtra(SimpleContentActivity.EXTRA_FILE,
//					"file:///android_asset/misc/help.html");
//
//			startActivity(i);
			
			
			// works:
			startActivity(new Intent(this, OtherActivity.class));

			return (true);
		}

		return (super.onOptionsItemSelected(item));
	}

	void setupPager(DiscountsModel model) {
		adapter = new DailyDiscountsAdapter(this, model);
		viewPager.setAdapter(adapter);

		findViewById(R.id.welcome).setVisibility(View.GONE);
		findViewById(R.id.viewPager).setVisibility(View.VISIBLE);
	}

}
