package com.ryujinkony.dailydiscounts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class DailyDiscountsActivity extends SherlockFragmentActivity {
	private static final String MODEL = "model";
	private ViewPager pager = null;
	private DailyDiscountsAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getSupportFragmentManager().findFragmentByTag(MODEL) == null) {
			getSupportFragmentManager().beginTransaction()
					.add(new ModelFragment(), MODEL).commit();
		}

		setContentView(R.layout.main);

		pager = (ViewPager) findViewById(R.id.viewPager);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.options, menu);
		return (super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			pager.setCurrentItem(0, false);
			return (true);

		case R.id.about:
			Intent i = new Intent(this, SimpleContentActivity.class);

			i.putExtra(SimpleContentActivity.EXTRA_FILE,
					"file:///android_asset/misc/about.html");
			startActivity(i);

			return (true);

		case R.id.help:
			i = new Intent(this, SimpleContentActivity.class);
			i.putExtra(SimpleContentActivity.EXTRA_FILE,
					"file:///android_asset/misc/help.html");

			startActivity(i);

			return (true);

		case R.id.simple:
			Intent intent = new Intent(this, OtherActivity.class);
			startActivity(intent);

			return (true);
		}

		return (super.onOptionsItemSelected(item));
	}
	
	void setupPager(DiscountsModel model) {
		adapter = new DailyDiscountsAdapter(this, model);
		pager.setAdapter(adapter);

		findViewById(R.id.welcome).setVisibility(View.GONE);
		findViewById(R.id.viewPager).setVisibility(View.VISIBLE);
	}
}
