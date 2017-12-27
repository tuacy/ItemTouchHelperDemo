package com.tuacy.itemdecoration.space;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class ItemDecorationSpace extends RecyclerView.ItemDecoration {

	private int mHorizontalOffset;
	private int mVerticalOffset;

	public ItemDecorationSpace(int horizontalOffset, int verticalOffset) {
		mHorizontalOffset = horizontalOffset;
		mVerticalOffset = verticalOffset;

	}

	/**
	 * 要给每个item设置间距主要靠这个函数来实现
	 */
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);
		int currentPosition = parent.getChildAdapterPosition(view);
		int itemCount = parent.getAdapter().getItemCount();
		RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {
			GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
			int spanCount = gridLayoutManager.getSpanCount();
			//行(如果不是最后一行)
			int rowCount = itemCount % spanCount == 0 ? itemCount / spanCount : itemCount / spanCount + 1;
			if (currentPosition <= (rowCount - 1) * spanCount) {
				outRect.bottom = mVerticalOffset;
			}
			//列(如果不是最后一列)
			if (currentPosition % spanCount != spanCount - 1) {
				outRect.right = mHorizontalOffset;
			}
		} else if (layoutManager instanceof LinearLayoutManager) {
			LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
			if (linearLayoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
				if (currentPosition != itemCount - 1) {
					outRect.bottom = mVerticalOffset;
				}
			} else {
				if (currentPosition != itemCount - 1) {
					outRect.right = mHorizontalOffset;
				}
			}
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
			int spanCount = staggeredGridLayoutManager.getSpanCount();
		}
	}
}
