package com.ryujinkony.dailydiscounts;

import org.json.JSONArray;
import org.json.JSONObject;

public class DiscountsModel {
	JSONObject rawJSON = null;
	JSONArray dailyDiscounts;

	public DiscountsModel(JSONObject rawJSON) {
		this.rawJSON = rawJSON;
		dailyDiscounts = rawJSON.optJSONArray("discounts");
	}

	int getDailyDiscountsCount() {
		return dailyDiscounts.length();
	}

	String getDailyDiscountFile(int position) {
		JSONObject dailyDiscount = dailyDiscounts.optJSONObject(position);

		return dailyDiscount.optString("file");
	}

	String getTitle() {
		return rawJSON.optString("title");
	}

}
