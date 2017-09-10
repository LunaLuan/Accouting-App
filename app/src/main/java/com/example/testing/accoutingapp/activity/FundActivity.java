package com.example.testing.accoutingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.testing.accoutingapp.R;
import com.example.testing.accoutingapp.adapter.FundAdapter;
import com.example.testing.accoutingapp.database.FundDataSource;
import com.example.testing.accoutingapp.model.Fund;

import java.util.List;

public class FundActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	private List<Fund> funds;

	private RecyclerView rvFund;
	private RecyclerView.Adapter fundAdapter;
	private RecyclerView.LayoutManager fundLayoutManager;

	private TextView tvSummary;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fund);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);


		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		rvFund = (RecyclerView) findViewById(R.id.content_fund_rvFund);
		rvFund.setHasFixedSize(true);

		fundLayoutManager = new LinearLayoutManager(this);
		rvFund.setLayoutManager(fundLayoutManager);

		funds = FundDataSource.listAll(this);
		fundAdapter = new FundAdapter(funds);
		rvFund.setAdapter(fundAdapter);

		tvSummary = (TextView) findViewById(R.id.content_fund_tvSummary);
		long totalAmount = 0;
		for(int i = 0; i < funds.size(); i++) {
			totalAmount += funds.get(i).getAmount();
		}
		tvSummary.setText("Tổng cộng: " + totalAmount + " VNĐ");
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fund, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();


		if (id == R.id.nav_income) {
			Intent intent = new Intent(this, IncomeActivity.class);
			startActivity(intent);

		} else if (id == R.id.nav_expenses) {

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);

		return true;
	}
}
