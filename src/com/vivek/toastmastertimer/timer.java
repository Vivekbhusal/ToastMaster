package com.vivek.toastmastertimer;


import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class timer extends Activity implements OnChronometerTickListener {

	
	public Button stop, record , pause;
	public Chronometer timingtv;
	public String time;
	public Boolean stoped = false, paused = true;
	String typeofspeaker;
	public String Greentime, Yellowtime, Redtime,timepaused;
	public RelativeLayout timerbackground;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		
		//using get intent to get the type to speaker
		Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
        	typeofspeaker = extras.getString("type"); 
        	Greentime = extras.getString("Gtime");
        	Yellowtime = extras.getString("Ytime");
        	Redtime = extras.getString("Rtime");
        	
        }
        timerbackground = (RelativeLayout) findViewById(R.id.timerbackground);
		
		
		timingtv = (Chronometer) findViewById(R.id.timingview);
		stop = (Button) findViewById(R.id.stop);
		record = (Button) findViewById(R.id.record);
		pause = (Button) findViewById(R.id.pause);
		
		timingtv.setOnChronometerTickListener(this);
		timingtv.start();	
		
				
		record.setEnabled(false);
		
		pause.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(paused){
					
					paused = false;	
					timepaused = (String) timingtv.getText();	
					timingtv.stop();
					Toast.makeText(timer.this, "Elapsed Time :"+ timepaused,Toast.LENGTH_SHORT).show();
					record.setEnabled(true);
					pause.setText("CONTINUE");
					
					
				}
				else{
					
					paused = true;
					int stoppedmillisecond = 0;
					record.setEnabled(true);
					//Log.i(timepaused, timepaused);						
					
					String array[]=timepaused.split(":");					
					stoppedmillisecond = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
					//Log.i("stoppedMS", String.valueOf(stoppedmillisecond));				
					timingtv.setBase(SystemClock.elapsedRealtime()- stoppedmillisecond);
					timingtv.start();
					pause.setText("PAUSE");
					
					
					
				}
				
			}
		});
		
		stop.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stoped = true;
				pause.setEnabled(false);
				timingtv.stop();
				record.setEnabled(true);				
				
			}
		});
		
		record.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(timer.this);
				 dialog.setContentView(R.layout.recorder);
				 dialog.setTitle("Enter Name of Speaker");

				 Button button = (Button) dialog.findViewById(R.id.button1);
				 dialog.getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				
				 button.setOnClickListener(new OnClickListener() {
				     public void onClick(View v) {
				    	 	
				    	 		EditText etname = (EditText) dialog.findViewById(R.id.etname);
				    	 		
					    	 	String name = etname.getText().toString();
								String type = typeofspeaker;
								String time = timingtv.getText().toString();
								
								recordindatabase entry = new recordindatabase(timer.this);
								entry.open();
								entry.creteEntry(name, type, time);
								entry.close();
				    	 	
				    	 dialog.dismiss();
				    	 finish();
				    	 overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right );
				    	 
				     }
				     });
				 dialog.show();
			}
				
				
			});
		
		
		
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		if(stoped != true)
		{
			Toast t = Toast.makeText(getApplicationContext(),"Stop before moving back..", Toast.LENGTH_SHORT);
			t.show();
		}
		else
		{
			super.onBackPressed();
			 overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right );
		}
		
	}
	public void onChronometerTick(Chronometer chronometer) {
		// TODO Auto-generated method stub
		if(Greentime.equals(timingtv.getText()))
		{
			timerbackground.setBackgroundColor(Color.GREEN);
			
		}
		else if(Yellowtime.equals(timingtv.getText()))
		{
			timerbackground.setBackgroundColor(Color.YELLOW);
		}
		else if(Redtime.equals(timingtv.getText()))
		{
			timerbackground.setBackgroundColor(Color.RED);
		}
		
	}

	
}
