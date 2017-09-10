package com.example.testing.accoutingapp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testing.accoutingapp.R;

/**
 * Created by asd on 9/6/2017.
 */

public class FundHolder extends RecyclerView.ViewHolder {

	public TextView tvName;
	public TextView tvAmount;

	public TextView tvPercent;
	public TextView tvDetail;

	public RelativeLayout rlSummary;
	public LinearLayout llDetail;

	public FundHolder(View itemView) {
		super(itemView);

		tvName = (TextView) itemView.findViewById(R.id.item_fund_tvName);
		tvAmount = (TextView) itemView.findViewById(R.id.item_fund_tvAmount);

		tvPercent = (TextView) itemView.findViewById(R.id.item_fund_tvPercent);
		tvDetail = (TextView) itemView.findViewById(R.id.item_fund_tvDetail);

		rlSummary = (RelativeLayout) itemView.findViewById(R.id.item_fund_rlSummary);
		llDetail = (LinearLayout) itemView.findViewById(R.id.item_fund_llDetail);
	}
}
