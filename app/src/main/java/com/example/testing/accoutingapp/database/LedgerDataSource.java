package com.example.testing.accoutingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.testing.accoutingapp.model.Ledger;

/**
 * Created by asd on 9/6/2017.
 */

public class LedgerDataSource {



	public static void insert(Context context, Ledger ledger) {
		insertLedger(context, ledger);
		updateFunds(ledger);
		insertTransition(ledger);
	}

	private static void insertTransition(Ledger ledger) {

	}

	private static void updateFunds(Ledger ledger) {

	}

	private static void insertLedger(Context context, Ledger ledger) {
		SQLiteDatabase db = DbHelper.getInstance(context).getWritableDatabase();

	}
}
