package com.example.testing.accoutingapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testing.accoutingapp.R;
import com.example.testing.accoutingapp.holder.FundHolder;
import com.example.testing.accoutingapp.model.Fund;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by asd on 9/6/2017.
 */

public class FundAdapter extends RecyclerView.Adapter<FundHolder> {

	private List<Fund> funds;

	public FundAdapter(List<Fund> funds) {
		this.funds = funds;
	}


	@Override
	public FundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fund, parent, false);
		return new FundHolder(itemView);
	}

	@Override
	public void onBindViewHolder(final FundHolder holder, int position) {
		Fund fund = funds.get(position);

		holder.tvName.setText(fund.getName());
		holder.tvDetail.setText("- Mục đích sử dụng: " + fund.getDetail());

		holder.tvAmount.setText(NumberFormat.getNumberInstance(Locale.US).format(fund.getAmount()) + " VNĐ");
		holder.tvPercent.setText("(" + fund.getPercent() + "% thu nhập)");

		holder.rlSummary.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(holder.llDetail.getVisibility() == View.VISIBLE)
					holder.llDetail.setVisibility(View.GONE);
				else
					holder.llDetail.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public int getItemCount() {
		return funds.size();
	}

	@Override
	public int getItemViewType(int position) {
		return super.getItemViewType(position);
	}
}
