package com.vivek.toastmastertimer;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	public ImageView eye;
	public TextView greentimer, yellowtimer, redtimer,speakertp;
	public Button icebreaker, project2to9, project10, evaluator, tabletopic, speech12min, speech15min, speech20min, speech30min,customtime,start;
	public String speakertype = null ;
	public String Greentime="00:00";
	public String Yellowtime="00:00";
	public String Redtime="00:00";
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.activity_main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
		case R.id.viewtiming:
		{			
					
			recordindatabase info = new recordindatabase(this);
			info.open();
			Cursor c= info.getData();
			opendisplydialog(c);
			info.close();
		
			break;
		}
			
		case R.id.deletetiming:
		{
			try{
				recordindatabase info = new recordindatabase(this);
				info.open();
				info.deleteall();
				info.close();
				Toast t = Toast.makeText(getApplicationContext(), "Records Deleted Successfully", Toast.LENGTH_SHORT);
				t.show();
				
			}catch(Exception e)
			{
				String error = e.toString();
				Toast t = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
				t.show();
			}
			break;
		}
			
		case R.id.feedback:
		{
			Intent i = new Intent(MainActivity.this, feedback.class);
			startActivity(i);
			break;
		}
		}
		return false;
	}

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maindisplay);
    
        
        Typeface face=Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-Bold.ttf");
        Typeface face1=Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-Regular.ttf");
               
        TextView toastmaster = (TextView) findViewById(R.id.toastmastertitle);
        toastmaster.setTypeface(face);
           
        speakertp = (TextView) findViewById(R.id.speakerText);
        speakertp.setTypeface(face);
        
        greentimer = (TextView) findViewById(R.id.green_time);
        yellowtimer = (TextView) findViewById(R.id.yellow_time);
        redtimer = (TextView) findViewById(R.id.red_time);
        
        icebreaker = (Button) findViewById(R.id.icebreaker);
        icebreaker.setTypeface(face1);
        
        project2to9 = (Button)findViewById(R.id.project2to9);
        project2to9.setTypeface(face1);
        
        project10 = (Button) findViewById(R.id.project10);
        project10.setTypeface(face1);
        
        evaluator = (Button) findViewById(R.id.evaluator);
        evaluator.setTypeface(face1);
        
        tabletopic = (Button) findViewById(R.id.tabletopic);
        tabletopic.setTypeface(face1);
        
        speech12min = (Button) findViewById(R.id.speech12min);
        speech12min.setTypeface(face1);
        
        speech15min = (Button) findViewById(R.id.speech15min);
        speech15min.setTypeface(face1);
        
        speech20min = (Button) findViewById(R.id.speech20min);
        speech20min.setTypeface(face1);
        
        speech30min = (Button) findViewById(R.id.speech30min);
        speech30min.setTypeface(face1);
        
        customtime = (Button) findViewById(R.id.customtime);
        customtime.setTypeface(face1);
        
        start = (Button) findViewById(R.id.starttimer);
        start.setTypeface(face);
        
        eye = (ImageView) findViewById(R.id.imageView1);
        eye.setOnClickListener(this);
        
      
        icebreaker.setOnClickListener(this);
        project2to9.setOnClickListener(this);
        project10.setOnClickListener(this);
        evaluator.setOnClickListener(this);
        tabletopic.setOnClickListener(this);
        speech12min.setOnClickListener(this);
        speech15min.setOnClickListener(this);
        speech20min.setOnClickListener(this);
        speech30min.setOnClickListener(this);
        customtime.setOnClickListener(this);
        
        start.setOnClickListener(this);
        
        speakertype = "IceBreaker";
		Greentime = "04:00";
		Yellowtime = "05:00";
		Redtime = "06:00";
        
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.imageView1:
		{
			recordindatabase info = new recordindatabase(this);
			info.open();
			Cursor c= info.getData();
			opendisplydialog(c);
			info.close();
			
			break;
		}
		case R.id.icebreaker:
		{
			greentimer.setText("04:00");
			yellowtimer.setText("05:00");
			redtimer.setText("06:00");
			speakertp.setText("ICE BREAKER");
//			start.setEnabled(true);
			speakertype = "IceBreaker";
			Greentime = "04:00";
			Yellowtime = "05:00";
			Redtime = "06:00";
			
			break;
		}

		case R.id.project2to9:
		{
			greentimer.setText("05:00");
			yellowtimer.setText("06:00");
			redtimer.setText("07:00");
			speakertp.setText("PROJECT 2-9");
			
			speakertype = "Project 2-9";
			Greentime = "05:00";
			Yellowtime = "06:00";
			Redtime = "07:00";
			break;
		}
		case R.id.project10:
		{
			greentimer.setText("08:00");
			yellowtimer.setText("09:00");
			redtimer.setText("10:00");
			speakertp.setText("PROJECT 10");
			
			speakertype = "Project 10";
			Greentime = "08:00";
			Yellowtime = "09:00";
			Redtime = "10:00";
			break;
		}
		case R.id.evaluator:
		{
			greentimer.setText("02:00");
			yellowtimer.setText("02:30");
			redtimer.setText("03:00");
			speakertp.setText("EVALUATOR");
			
			speakertype = "Evaluator";
			Greentime = "02:00";
			Yellowtime = "02:30";
			Redtime = "03:00";
			break;
		}
		case R.id.tabletopic:
		{
			greentimer.setText("01:00");
			yellowtimer.setText("01:30");
			redtimer.setText("02:00");
			speakertp.setText("TABLE TOPIC");
			
			speakertype = "TableTopic";
			Greentime = "01:00";
			Yellowtime = "01:30";
			Redtime = "02:00";
			break;
		}
		case R.id.speech12min:
		{
			greentimer.setText("10:00");
			yellowtimer.setText("11:00");
			redtimer.setText("12:00");
			speakertp.setText("12MIN SPEAKER");
			
			speakertype = "12min Speaker";
			Greentime = "10:00";
			Yellowtime = "11:00";
			Redtime = "12:00";
			break;
		}
		case R.id.speech15min:
		{
			greentimer.setText("13:00");
			yellowtimer.setText("14:00");
			redtimer.setText("15:00");
			speakertp.setText("15MIN SPEAKER");
			
			speakertype = "15min Speaker";
			Greentime = "13:00";
			Yellowtime = "14:00";
			Redtime = "15:00";
			break;
		}
		case R.id.speech20min:
		{
			greentimer.setText("18:00");
			yellowtimer.setText("19:30");
			redtimer.setText("20:00");
			speakertp.setText("20MIN SPEAKER");
			
			speakertype = "20min Speaker";
			Greentime = "18:00";
			Yellowtime = "19:00";
			Redtime = "20:00";
			break;
		}
		case R.id.speech30min:
		{
			greentimer.setText("28:00");
			yellowtimer.setText("29:30");
			redtimer.setText("30:00");
			speakertp.setText("30MIN SPEAKER");
			
			speakertype = "30min Speaker";
			Greentime = "28:00";
			Yellowtime = "29:00";
			Redtime = "30:00";
			break;
		}
		case R.id.customtime:
		{
			final Dialog dialog = new Dialog(MainActivity.this);
			 dialog.setContentView(R.layout.customtiming);
			 dialog.setTitle("Define Time:");

			 Button button = (Button) dialog.findViewById(R.id.button1);
			
			 button.setOnClickListener(new OnClickListener() {
			     public void onClick(View v) {
			    	 		EditText green= (EditText) dialog.findViewById(R.id.customgreen);
			    	 		EditText yellow= (EditText) dialog.findViewById(R.id.customyellow);
			    	 		EditText red= (EditText) dialog.findViewById(R.id.customred);
			    	 		
			    	 		String Greentime = green.getText().toString();
			    	 		String Yellowtime = yellow.getText().toString();
			    	 		String Redtime = red.getText().toString();
			    	 		
			    	 		Intent intent = new Intent(MainActivity.this, timer.class);
			    			intent.putExtra("type", "Custom Time");
			    			intent.putExtra("Gtime", Greentime);
			    			intent.putExtra("Ytime", Yellowtime);
			    			intent.putExtra("Rtime", Redtime);			
			    			startActivity(intent);
			    	//		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			    	 
			    	 dialog.dismiss();
			     	}
			     });
			 dialog.show();
			 break;
		}
		case R.id.starttimer:
		{
			Intent intent = new Intent(MainActivity.this, timer.class);
			intent.putExtra("type", speakertype);
			intent.putExtra("Gtime", Greentime);
			intent.putExtra("Ytime", Yellowtime);
			intent.putExtra("Rtime", Redtime);			
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			
		}
		
		
		default:
			break;
		}
		
	}

	private void opendisplydialog(Cursor c) {
		// TODO Auto-generated method stub

		final String KEY_NAME = "Speaker_name";
		final String KEY_TYPE = "Skeaker_type";
		final String KEY_TIME = "Skeaker_time";
		final Dialog dialog;
		
		
		
		int totalnumberofrow = c.getCount();
		//Log.e("number_of_row",Integer.toString(totalnumberofrow));
		
		c.moveToFirst();
		if(totalnumberofrow > 0){
			
			int iName = c.getColumnIndex(KEY_NAME);
			int iType = c.getColumnIndex(KEY_TYPE);
			int iTime = c.getColumnIndex(KEY_TIME);
			
			dialog = new Dialog(MainActivity.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);	
			dialog.setContentView(R.layout.displayrecord);
			
			
			TableLayout tablelayout = (TableLayout) dialog.findViewById(R.id.tablelayoutview);
			
			TableRow[] tablerow = new TableRow[totalnumberofrow];
			TextView[] speakername = new TextView[totalnumberofrow];
			TextView[] speakertype = new TextView[totalnumberofrow];
			TextView[] speakertime = new TextView[totalnumberofrow];
			
			
			int i=0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
			{
				i = c.getPosition();
			//	Log.e("current position", Integer.toString(i));
				
				tablerow[i] = new TableRow(this);
				
				speakername[i] = new TextView(this);
					speakername[i].setText(c.getString(iName));
					speakername[i].setTextColor(Color.WHITE);
				
				speakertype[i] = new TextView(this);
					speakertype[i].setText(c.getString(iType));
					speakertype[i].setTextColor(Color.WHITE);
					
				speakertime[i] = new TextView(this);
					speakertime[i].setText(c.getString(iTime));
					speakertime[i].setTextColor(Color.WHITE);
					
				tablerow[i].addView(speakername[i]);
				tablerow[i].addView(speakertype[i]);
				tablerow[i].addView(speakertime[i]);
				
				tablelayout.addView(tablerow[i]);
								
			}
			
			dialog.show();
			
			ImageView delete  = (ImageView) dialog.findViewById(R.id.deleteView);
			delete.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					
					try{
						recordindatabase info = new recordindatabase(MainActivity.this);
						info.open();
						info.deleteall();
						info.close();
						Toast t = Toast.makeText(getApplicationContext(), "Records Deleted Successfully", Toast.LENGTH_SHORT);
						t.show();
						
						
					}catch(Exception e)
					{
						String error = e.toString();
						Toast t = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
						t.show();
					}
					dialog.dismiss();
					
				}
			});
			
			
			

		}else{
			Toast t = Toast.makeText(getApplicationContext(),"No Record Found", Toast.LENGTH_LONG);
			t.show();
		}
		
		c.close();
		
	}
    
}

