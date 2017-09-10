package com.example.testing.accoutingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by asd on 9/5/2017.
 */

public class AccountingDatabase extends SQLiteOpenHelper {

	public static final String name = "AccountingApp.db";
	private static String DB_PATH;

	private Context context;

	public AccountingDatabase(Context context) {
		super(context, name, null, 3);
		if(Build.VERSION.SDK_INT >= 17) {
			DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
		}
		else {
			DB_PATH = "data/data/" + context.getPackageName() + "databases";
		}

		this.context = context;
		if(!checkDatabase()) {
			createDatabase();
		}
	}

	private void createDatabase() {
		if(!checkDatabase()) {
			this.getReadableDatabase();
			this.close();

			try {
				copyDatabase();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 	}

	private boolean checkDatabase() {
		File f = new File(DB_PATH + name);
		Log.i("Check database", f.exists() + "");
		return f.exists();
	}


	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		if(!checkDatabase())
			createDatabase();
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

	}

	public void copyDatabase() throws IOException {
		Log.i("Copying database", "");

		InputStream inputStream = context.getAssets().open(name);
		String outFileName = DB_PATH + name;
		OutputStream outputStream = new FileOutputStream(outFileName);

		byte mBuffer[] = new byte[1024];
		int mLength;

		while ((mLength = inputStream.read(mBuffer)) > 0) {
			outputStream.write(mBuffer, 0, mLength);
		}

		outputStream.flush();
		outputStream.close();

		inputStream.close();

		Log.i("Copy database succees", "");
	}
}
