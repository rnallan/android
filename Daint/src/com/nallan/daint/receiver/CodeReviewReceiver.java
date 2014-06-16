package com.nallan.daint.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nallan.daint.activity.RefreshCodeReviewScreenActivity;
import com.nallan.daint.service.CodeReviewService;

public   class CodeReviewReceiver extends BroadcastReceiver {
	
	public CodeReviewReceiver()
	{
		super();
		System.out.println("empty constructor : as per the Android API requirement");
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent target = new Intent(context, RefreshCodeReviewScreenActivity.class);
		target.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		String text = intent.getStringExtra(CodeReviewService.COMPLETE_NAME);
		target.putExtra(CodeReviewService.COMPLETE_NAME, text);
		context.startActivity(target);
		System.out.println("Starting activity again !!!");
	}
}


