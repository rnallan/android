package com.nallan.daint.activity;

import com.nallan.daint.service.CodeReviewService;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class CodeReviewClientActivity extends Activity {

	
	public void onCompleteName(View v) {
		Intent intent = new Intent();
		intent.putExtra("firstName", "Raghuram");
		intent.putExtra("lastName", "Nallan Chakravarthula");
		startService(new Intent(getBaseContext(),CodeReviewService.class));
	}
}
