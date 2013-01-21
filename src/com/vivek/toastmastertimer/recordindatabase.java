package com.vivek.toastmastertimer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class recordindatabase extends Activity {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "Speaker_name";
	public static final String KEY_TYPE = "Skeaker_type";
	public static final String KEY_TIME = "Skeaker_time";
	
	private static final String DATABASE_NAME ="toastmasterdb";
	private static final String DATABASE_TABLE = "speaker";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
			db.execSQL("CREATE TABLE " + DATABASE_TABLE +" ("+
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
					KEY_NAME + " TEXT NOT NULL, "+
					KEY_TYPE+ " TEXT NOT NULL, "+
					KEY_TIME+ " TEXT NOT NULL );"			
				);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
			
			
		}
		
	}
	
	public recordindatabase(Context c)
	{
		ourContext = c;
	}
	
	public recordindatabase open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
		
	}
	public void close()
	{
		ourHelper.close();
	}

	public long creteEntry(String name, String type, String time){
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_TYPE, type);
		cv.put(KEY_TIME, time);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}

	public Cursor getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_NAME, KEY_TYPE, KEY_TIME};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		
		return c;
			
	}

	public void deleteall() throws SQLException {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, null, null);
			
	}

	
	
	
}
