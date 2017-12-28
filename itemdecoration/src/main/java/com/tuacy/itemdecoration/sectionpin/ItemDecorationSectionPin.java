package com.tuacy.itemdecoration.sectionpin;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class ItemDecorationSectionPin extends RecyclerView.ItemDecoration {

	/**
	 * 把要固定的View绘制在上层
	 */
	@Override
	public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
		super.onDrawOver(c, parent, state);
		//确保是SectionPinAdapter的adapter,确保有View
		if (parent.getAdapter() instanceof SectionPinAdapter && parent.getChildCount() > 0) {
			SectionPinAdapter adapter = (SectionPinAdapter) parent.getAdapter();
			//找到要固定的pin view
			View firstView = parent.getChildAt(0);
			int firstAdapterPosition = parent.getChildAdapterPosition(firstView);
			int pinAdapterPosition = getPinViewAdapterPosition(firstAdapterPosition, adapter);
			if (pinAdapterPosition != -1) {
				RecyclerView.ViewHolder pinViewHolder = adapter.onCreateViewHolder(parent, adapter.getItemViewType(pinAdapterPosition));
				adapter.onBindViewHolder(pinViewHolder, pinAdapterPosition);
				//要固定的view
				View sectionPinView = pinViewHolder.itemView;
				ensurePinViewLayout(sectionPinView, parent);
				int sectionPinOffset = 0;
				for (int index = 0; index < parent.getChildCount(); index++) {
					if (adapter.isSection(parent.getChildAdapterPosition(parent.getChildAt(index)))) {
						View sectionView = parent.getChildAt(index);
						int sectionTop = sectionView.getTop();
						int pinViewHeight = sectionPinView.getHeight();
						if (sectionTop < pinViewHeight && sectionTop > 0) {
							sectionPinOffset = sectionTop - pinViewHeight;
						}
					}
				}
				int saveCount = c.save();
				c.translate(0, sectionPinOffset);
				c.clipRect(0, 0, parent.getWidth(), sectionPinView.getMeasuredHeight());
				sectionPinView.draw(c);
				c.restoreToCount(saveCount);
			}

		}
	}

	/**
	 * 要给每个item设置间距主要靠这个函数来实现
	 */
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
	}

	/**
	 * 根据第一个可见的adapter的位置去获取临近的一个section的位置
	 *
	 * @param adapterFirstVisible 第一个可见的adapter的位置
	 * @return -1：未找到 >=0 找到位置
	 */
	private int getPinViewAdapterPosition(int adapterFirstVisible, SectionPinAdapter adapter) {
		for (int index = adapterFirstVisible; index >= 0; index--) {
			if (adapter.isSection(index)) {
				return index;
			}
		}
		return -1;
	}

	private void ensurePinViewLayout(View pinView, RecyclerView recyclerView) {
		if (pinView.isLayoutRequested()) {
			/**
			 * 用的是RecyclerView的宽度测量，和RecyclerView的宽度一样
			 */
			int widthSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getMeasuredWidth(), View.MeasureSpec.EXACTLY);

			int heightSpec;
			ViewGroup.LayoutParams layoutParams = pinView.getLayoutParams();
			if (layoutParams != null && layoutParams.height > 0) {
				heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, View.MeasureSpec.EXACTLY);
			} else {
				heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
			}
			pinView.measure(widthSpec, heightSpec);
			pinView.layout(0, 0, pinView.getMeasuredWidth(), pinView.getMeasuredHeight());
		}
	}
}
