package com.application.christmasbubble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.application.christmasbubble.R;

public class SplashActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);


		Thread splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (waited < 2000) {
						sleep(100);
						waited += 100;
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {

					Intent i = new Intent(getApplicationContext(),Start_Activity.class);
					startActivity(i);
					finish();

				}
			}
		};
		splashThread.start();
	}

}