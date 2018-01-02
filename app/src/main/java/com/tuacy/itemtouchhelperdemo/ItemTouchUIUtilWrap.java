package com.tuacy.itemtouchhelperdemo;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.View;


public class ItemTouchUIUtilWrap implements ItemTouchUIUtil {

	@Override
	public void onDraw(Canvas c, RecyclerView recyclerView, View view, float dX, float dY, int actionState, boolean isCurrentlyActive) {
		if (isCurrentlyActive) {
			Object originalElevation = view.getTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation);
			if (originalElevation == null) {
				originalElevation = ViewCompat.getElevation(view);
				float newElevation = 1f + findMaxElevation(recyclerView, view);
				ViewCompat.setElevation(view, newElevation);
				view.setTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation, originalElevation);
			}
		}
		view.setTranslationX(dX);
		view.setTranslationY(dY);
	}

	@Override
	public void onDrawOver(Canvas c, RecyclerView recyclerView, View view, float dX, float dY, int actionState, boolean isCurrentlyActive) {

	}

	@Override
	public void clearView(View view) {
		final Object tag = view.getTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation);
		if (tag != null && tag instanceof Float) {
			ViewCompat.setElevation(view, (Float) tag);
		}
		view.setTag(android.support.v7.recyclerview.R.id.item_touch_helper_previous_elevation, null);
		view.setTranslationX(0f);
		view.setTranslationY(0f);
	}

	@Override
	public void onSelected(View view) {

	}

	private float findMaxElevation(RecyclerView recyclerView, View itemView) {
		final int childCount = recyclerView.getChildCount();
		float max = 0;
		for (int i = 0; i < childCount; i++) {
			final View child = recyclerView.getChildAt(i);
			if (child == itemView) {
				continue;
			}
			final float elevation = ViewCompat.getElevation(child);
			if (elevation > max) {
				max = elevation;
			}
		}
		return max;
	}
}
