package com.vivek.toastmastertimer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class feedback extends Activity {

	
	public EditText messagebox;
	public Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		messagebox = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_SUBJECT, "Mail From Toastmaster App - Android");
				intent.putExtra(Intent.EXTRA_TEXT, messagebox.getText().toString());
				intent.setData(Uri.parse("mailto:vivekbhusal@gmail.com")); // or just "mailto:" for blank
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
				startActivity(intent);
				
			}
		});
		
		
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
