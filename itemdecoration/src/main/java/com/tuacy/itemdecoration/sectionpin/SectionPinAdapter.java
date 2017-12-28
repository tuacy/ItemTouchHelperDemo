package com.tuacy.itemdecoration.sectionpin;


import android.support.v7.widget.RecyclerView;

public abstract class SectionPinAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

	/**
	 * 判断是否是section
	 *
	 * @param position adapter position
	 * @return true or false
	 */
	public abstract boolean isSection(int position);

}
