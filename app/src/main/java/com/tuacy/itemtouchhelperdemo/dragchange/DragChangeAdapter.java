package com.tuacy.itemtouchhelperdemo.dragchange;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuacy.itemtouchhelperdemo.R;

import java.util.List;

public class DragChangeAdapter extends RecyclerView.Adapter<DragChangeAdapter.DragChangeHolder> {

	private List<ApkInfo> mDataList;

	DragChangeAdapter() {
		this(null);
	}

	DragChangeAdapter(List<ApkInfo> dataList) {
		mDataList = dataList;
	}

	public void setData(List<ApkInfo> dataList) {
		mDataList = dataList;
		notifyDataSetChanged();
	}

	@Override
	public DragChangeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new DragChangeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_change, parent, false));
	}

	@Override
	public void onBindViewHolder(DragChangeHolder holder, int position) {
		holder.mTextName.setText(mDataList.get(position).getApkName());
		holder.mImageIcon.setImageDrawable(mDataList.get(position).getImage());
	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	static class DragChangeHolder extends RecyclerView.ViewHolder {

		ImageView mImageIcon;
		TextView  mTextName;

		DragChangeHolder(View itemView) {
			super(itemView);
			mImageIcon = itemView.findViewById(R.id.image_apk_icon);
			mTextName = itemView.findViewById(R.id.text_apk_name);
		}
	}

}
