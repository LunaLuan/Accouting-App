package com.example.testing.accoutingapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asd on 9/5/2017.
 */

public abstract class Ledger {

	private int ledgerId;
	private String name;
	private String detail;

	private String date;

	private List<Fund> funds;
	protected List<Long> amounts;


	public Ledger() {
		amounts = new ArrayList<Long>();
	}


	public List<Fund> getFunds() {
		return funds;
	}



	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public int getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public abstract void execute();
}
