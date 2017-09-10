package com.example.testing.accoutingapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by asd on 9/5/2017.
 */

public class DbHelper {

	private static DbHelper instance;

	private SQLiteOpenHelper accoutingDatabase;

	private DbHelper(Context context) {
		accoutingDatabase = new AccountingDatabase(context);
	}

	public synchronized static DbHelper getInstance(Context context) {
		if(instance == null) {
			instance = new DbHelper(context);
		}
		return  instance;
	}

	public void testTableInDatabase() {
		String table = "";
		Cursor c = getReadableDatabase().rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
		c.moveToFirst();
		while (!c.isAfterLast()) {
			table += c.getString(c.getColumnIndex("name"));
			c.moveToNext();
		}
		Log.i("Tables in database ", table);
		c.close();
	}

	public SQLiteDatabase getReadableDatabase() {
		return accoutingDatabase.getReadableDatabase();
	}

	public SQLiteDatabase getWritableDatabase() {
		return  accoutingDatabase.getWritableDatabase();
	}

	public void close() {
		accoutingDatabase.close();
	}

}
