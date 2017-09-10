package com.example.testing.accoutingapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testing.accoutingapp.model.Fund;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asd on 9/5/2017.
 */

public class FundDataSource {

	public static final String table = "Fund";
	public static final String fundId = "fund_id";
	public static final String name = "name";
	public static final String detail = "detail";
	public static final String amount = "amount";
	public static final String percent = "percent";

	public static List<Fund> listAll(Context context) {
		SQLiteDatabase db = DbHelper.getInstance(context).getReadableDatabase();

		DbHelper.getInstance(context).testTableInDatabase();

		String columns[] = new String[]{fundId, name, detail, amount, percent};
		Cursor cursor = db.query(table, columns, null, null, null, null, null, null);

		List<Fund> funds = new ArrayList<Fund>();

		cursor.moveToFirst();
		for(int i = 0; i < cursor.getCount(); i++) {
			Fund nf = new Fund();
			nf.setFundId(cursor.getInt(cursor.getColumnIndex(fundId)));
			nf.setName(cursor.getString(cursor.getColumnIndex(name)));
			nf.setDetail(cursor.getString(cursor.getColumnIndex(detail)));
			nf.setAmount(cursor.getLong(cursor.getColumnIndex(amount)));
			nf.setPercent(cursor.getDouble(cursor.getColumnIndex(percent)));

			funds.add(nf);

			cursor.moveToNext();
		}
		cursor.close();
		db.close();

		return funds;
	}

	public static Fund findById(int id) {
		return null;
	}



}
