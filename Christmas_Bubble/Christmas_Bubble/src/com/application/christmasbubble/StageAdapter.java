package com.application.christmasbubble;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.application.christmasbubble.R;

public class StageAdapter extends BaseAdapter {
	
	
	Activity activity;
	ArrayList<String> data;
	LayoutInflater inflate;
	KeyClickListener mListener;
	int NumberStageCom;
	public StageAdapter(Game_Activity bubblemain, ArrayList<String> number,KeyClickListener listener,int NumberCompleted) {
		// TODO Auto-generated constructor stub
		
		this.activity=bubblemain;
		this.data=number;
		inflate = (LayoutInflater)activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		this.mListener = listener;
		this.NumberStageCom=NumberCompleted;
		 Log.e("Number of Stage Clear",""+NumberStageCom);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public class ViewHolder {
	 
		Button btnstage;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Button btnstage;
		 

		 if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            btnstage = (Button)inflater.inflate(R.layout.stage_item,parent,false);
	        } else {
	        	btnstage = (Button) convertView;
	        }
		btnstage.setText(data.get(position));
		btnstage.setId(position+1);
		
		 if (btnstage.getId()<=NumberStageCom)
		 {
			 btnstage.setBackgroundResource(R.drawable.unlocked);
		 }
	     else
	     {
	    	 btnstage.setBackgroundResource(R.drawable.locked);
	     }
	        	 
		
	  	
		 btnstage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.e("id", ""+btnstage.getId());
				if(btnstage.getId()<=NumberStageCom)
				{
					 Animation localAnimation = AnimationUtils.loadAnimation(activity, R.anim.unlock);
					 v.startAnimation(localAnimation);
					 mListener.keyClickedIndex(position+1);
				}
				else
				{
					Animation localAnimation = AnimationUtils.loadAnimation(activity, R.anim.loked);
					v.startAnimation(localAnimation);
				}
				 
		 
			}
		});
		 return btnstage;
	}
	
	
	public interface KeyClickListener
	{
		public void keyClickedIndex(int index);
	}

}
