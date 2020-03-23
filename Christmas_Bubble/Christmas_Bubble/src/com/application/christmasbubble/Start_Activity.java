package com.application.christmasbubble;

import com.application.christmasbubble.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Start_Activity extends Activity{

	Button btn_play,btn_about,btn_rateapp;
	private AdView mAdView;
 	private InterstitialAd mInterstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		
		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());
		
		mInterstitial = new InterstitialAd(this);
		mInterstitial.setAdUnitId(getResources().getString(R.string.admob_publisher_interstitial_id));
		mInterstitial.loadAd(new AdRequest.Builder().build());

		btn_play=(Button)findViewById(R.id.btnplay);
		btn_about=(Button)findViewById(R.id.btnabout);
		btn_rateapp=(Button)findViewById(R.id.btnrateapp);

		btn_play.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentpay=new Intent(getApplicationContext(),Game_Activity.class);
				startActivity(intentpay);
			}
		});
		btn_about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intenabout=new Intent(getApplicationContext(),AboutActivity.class);
				startActivity(intenabout);
			}
		});
		btn_rateapp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String appName = getPackageName();//your application package name i.e play store application url
				try {
					startActivity(new Intent(Intent.ACTION_VIEW,
							Uri.parse("market://details?id="
									+ appName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/store/apps/details?id="
									+ appName)));
				}
	    		 
	       
			}
		});
		
	}	
		 @Override
	  		public boolean onKeyDown(int keyCode, KeyEvent event) {
	  		// TODO Auto-generated method stub
	  		
	  		if (keyCode == KeyEvent.KEYCODE_BACK) {
	  			// Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
	  			AlertDialog.Builder alert = new AlertDialog.Builder(
	  					Start_Activity.this);
	  			alert.setTitle(getString(R.string.app_name));
	  			alert.setIcon(R.drawable.app_icon);
	  			alert.setMessage("Are You Sure You Want To Quit?");
	  		
	  			alert.setPositiveButton("Yes",
	  					new DialogInterface.OnClickListener() {
	  						public void onClick(DialogInterface dialog,
	  								int whichButton) {
	  							
	  							 //you may open Interstitial Ads here
	  							if (mInterstitial.isLoaded()) {
	  								mInterstitial.show();
	  							}
	  							finish();
	  						}

	  			});
	  		
	  			alert.setNegativeButton("NO",
	  					new DialogInterface.OnClickListener() {
	  		
	  						public void onClick(DialogInterface dialog, int which) {
	  							// TODO Auto-generated method stub
	  							 
	  							 
	  						}
	  					});
	  			alert.show();
	  			return true;
	  		}
	  		
	  		return super.onKeyDown(keyCode, event);
	  		
	  		}
	}

 