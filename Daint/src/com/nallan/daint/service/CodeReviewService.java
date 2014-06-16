package com.nallan.daint.service;

import com.nallan.daint.activity.CodeReviewActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;

public class CodeReviewService extends IntentService {

	public static final String COMPLETE_NAME = "completeName";
	public static final String COMPLETE_NAME_ACTION = "COMPLETE_NAME_ACTION";

	public CodeReviewService( )
	{
		super("ok");
	}
	
	public CodeReviewService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		String firstName = intent.getStringExtra(CodeReviewActivity.FIRST_NAME);
		String lastName =  intent.getStringExtra(CodeReviewActivity.LAST_NAME);
		String completName = lastName + ": " + firstName;
		new CodeReviewWebServiceClient().execute(completName);
	}

	private void compute(String completName) {
		
		Intent broadcastIntent = new  Intent(COMPLETE_NAME_ACTION);
		broadcastIntent.putExtra(COMPLETE_NAME, completName);
		sendBroadcast(broadcastIntent);
	}
	
	class CodeReviewWebServiceClient extends AsyncTask<String, String, String>
	{
		
		@Override
		protected String doInBackground(String... params) {
			return params[0];
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			compute(result);
		}
	
	}
}
