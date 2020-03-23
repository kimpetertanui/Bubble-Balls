package com.application.christmasbubble;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.application.christmasbubble.R;

public class AboutActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_activity);



		;
	}

}
