package com.tuacy.itemtouchhelperdemo.swipe;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuacy.itemtouchhelperdemo.R;

import java.util.List;

public class SwipeDeleteAdapter extends RecyclerView.Adapter<SwipeDeleteAdapter.DragDeleteHolder> {

	private List<String> mDataList;

	SwipeDeleteAdapter() {
		this(null);
	}

	SwipeDeleteAdapter(List<String> dataList) {
		mDataList = dataList;
	}

	public void setData(List<String> dataList) {
		mDataList = dataList;
		notifyDataSetChanged();
	}

	@Override
	public DragDeleteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new DragDeleteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_delete, parent, false));
	}

	@Override
	public void onBindViewHolder(DragDeleteHolder holder, int position) {
		holder.mTextTitle.setText(mDataList.get(position));
	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	static class DragDeleteHolder extends RecyclerView.ViewHolder {

		TextView mTextTitle;

		DragDeleteHolder(View itemView) {
			super(itemView);
			mTextTitle = itemView.findViewById(R.id.text_drag_delete_title);
		}
	}

}
