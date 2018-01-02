package com.tuacy.itemtouchhelperdemo.drag.dragsimple;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
		int adapterPosition = parent.getChildAdapterPosition(view);
		if (!(adapterPosition % layoutManager.getSpanCount() == 2)) {
			outRect.right = 20;
		}
		int totalCount = parent.getAdapter().getItemCount();
		int rowCount = totalCount % layoutManager.getSpanCount() == 0 ? totalCount / layoutManager.getSpanCount() :
					   totalCount / layoutManager.getSpanCount() + 1;
		if (adapterPosition < layoutManager.getSpanCount() * (rowCount - 1)) {
			outRect.bottom = 20;
		}
	}
}
