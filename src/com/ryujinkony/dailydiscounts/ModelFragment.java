package com.ryujinkony.dailydiscounts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.actionbarsherlock.app.SherlockFragment;
import org.json.JSONObject;

public class ModelFragment extends SherlockFragment {
	private DiscountsModel discountsModel = null;
	private DiscountsLoadTask discountsLoadTask = null;

	@Override
	public void onActivityCreated(Bundle icicle) {
		super.onActivityCreated(icicle);

		setRetainInstance(true);
		deliverModel();
	}

	synchronized private void deliverModel() {
		if (discountsModel != null) {
			((DailyDiscountsActivity) getActivity()).setupPager(discountsModel);
		} else {
			if (discountsModel == null && discountsLoadTask == null) {
				discountsLoadTask = new DiscountsLoadTask();
				executeAsyncTask(discountsLoadTask, getActivity()
						.getApplicationContext());
			}
		}
	}

	@TargetApi(11)
	static <T> void executeAsyncTask(AsyncTask<T, ?, ?> task, T... params) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
		} else {
			task.execute(params);
		}
	}

	private class DiscountsLoadTask extends AsyncTask<Context, Void, Void> {
		DiscountsModel localDiscountsModel = null;
		Exception e = null;

		@Override
		protected Void doInBackground(Context... ctxt) {
			try {
				StringBuilder sb = new StringBuilder();
				InputStream json = ctxt[0].getAssets().open(
						"discounts/contents.json");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(json));

				String str;

				while ((str = reader.readLine()) != null) {
					sb.append(str);
				}
				reader.close();

				localDiscountsModel = new DiscountsModel(new JSONObject(
						sb.toString()));
			} catch (Exception e) {
				this.e = e;
			}
			return null;
		}

		@Override
		public void onPostExecute(Void arg0) {
			if (e == null) {
				ModelFragment.this.discountsModel = localDiscountsModel;
				ModelFragment.this.discountsLoadTask = null;
				deliverModel();
			} else {
				Log.e(getClass().getSimpleName(),
						"Exception Loading Discounts", e);
			}
		}
	}

}
