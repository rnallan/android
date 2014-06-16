package com.nallan.daint.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.appnavigation.R;
import com.nallan.daint.service.CodeReviewService;

public class RefreshCodeReviewScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// call service
		setContentView(R.layout.review);
		TextView result = (TextView) findViewById(R.id.combined_name);
		result.setText(getIntent().getStringExtra(CodeReviewService.COMPLETE_NAME));
	}
}
