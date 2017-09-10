package com.example.testing.accoutingapp.model;

import java.util.List;

/**
 * Created by asd on 9/7/2017.
 */

public class Expenses extends Ledger {


	private long totalAmount;

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public void execute() {
		List<Fund> funds = getFunds();
		for(int i = 0; i < funds.size(); i++) {
			Fund fund = funds.get(i);

			long amount = (long) (totalAmount * fund.getPercent() / 100);
			fund.setAmount(fund.getAmount() - amount);
		}
	}
}
