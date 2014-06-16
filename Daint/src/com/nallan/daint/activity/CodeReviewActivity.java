package com.nallan.daint.activity;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nallan.daint.receiver.CodeReviewReceiver;
import com.nallan.daint.service.CodeReviewService;

public class CodeReviewActivity extends Activity {

	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME = "firstName";
	BroadcastReceiver receiver;
	IntentFilter intentFilter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_code_review);
		intentFilter = new IntentFilter(CodeReviewService.COMPLETE_NAME_ACTION);
		receiver = new CodeReviewReceiver();
	}

	public void onViewContent(View v) {
		// call service
		setContentView(R.layout.review);
	}

	public void onCompleteName(View v) {
		
		Intent intent = new Intent(this, CodeReviewService.class);
		TextView firstName = (TextView)findViewById(R.id.first_name);
		TextView secondName = (TextView)findViewById(R.id.second_name);
		
		intent.putExtra(FIRST_NAME, firstName.getText().toString());
		intent.putExtra(LAST_NAME, secondName.getText().toString());
		
		ComponentName startedService = startService(intent);
		System.out.println("the service started is:" + startedService);
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(receiver, intentFilter);
	}

	@Override
	protected void onPause() {
		super.onResume();
		unregisterReceiver(receiver);
	}

}
