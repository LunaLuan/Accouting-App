package com.example.testing.accoutingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.testing.accoutingapp.R;
import com.example.testing.accoutingapp.model.Income;

public class IncomeActivity extends AppCompatActivity {

	private Income income = new Income();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income);


	}

	public void clickBtnExecute(View view) {

	}
}
