package com.tuacy.itemtouchhelperdemo.dragchange;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemPositionChangeCallback extends ItemTouchHelper.SimpleCallback {

	private final ItemPositionChangeHelper mItemPositionChangeHelper;


	public ItemPositionChangeCallback(ItemPositionChangeHelper positionChangeHelper) {
		super(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
		mItemPositionChangeHelper = positionChangeHelper;
	}

	@Override
	public boolean isLongPressDragEnabled() {
		return true;
	}

	@Override
	public boolean isItemViewSwipeEnabled() {
		return false;
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
		mItemPositionChangeHelper.onItemPositionChange(viewHolder.getAdapterPosition(), target.getAdapterPosition());
		return true;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

	}
}
