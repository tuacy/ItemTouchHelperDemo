package com.tuacy.itemtouchhelperdemo.drag;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


public class DragCallback extends ItemTouchHelper.SimpleCallback {

	private final DragHelper mDragHelper;


	public DragCallback(DragHelper positionChangeHelper) {
		super(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
		mDragHelper = positionChangeHelper;
	}

	@Override
	public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
		super.onSelectedChanged(viewHolder, actionState);
		if (viewHolder != null) {
			mDragHelper.onDragStart();
		} else {
			mDragHelper.onDragEnd();
		}
	}

	@Override
	public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
		return current.getItemViewType() == target.getItemViewType();
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
		mDragHelper.onDragPositionChange(viewHolder.getAdapterPosition(), target.getAdapterPosition());
		return true;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

	}
}
