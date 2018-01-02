package com.tuacy.itemtouchhelperdemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;


public abstract class CallbackHelp extends ItemTouchHelper.Callback {

	/**
	 * 针对swipe和drag状态，设置不同状态(swipe、drag)下可以移动的方向
	 * idle:0~7位表示swipe和drag的方向
	 * swipe:8~15位表示滑动方向
	 * drag:16~23位表示拖动方向
	 */
	public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

	/**
	 * 针对drag状态,当item长按的时候是否允许进入drag(拖动)状态
	 */
	public boolean isLongPressDragEnabled() {
		return true;
	}

	/**
	 * 针对swipe和drag状态，当swipe或者drag对应的ViewHolder改变的时候调用
	 * 我们可以通过重写这个函数得到swipe或者drag开始和结束时机，viewHolder 不为空的时候是开始，空的时候是结束
	 */
	public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
		super.onSelectedChanged(viewHolder, actionState);
	}

	/**
	 * 针对drag状态，当前target对应的item是否可以加入drag状态
	 * 换句话说我们一般用drag来做一些换位置的操作，就是当前target对应的item是否可以换位置
	 */
	public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
		return true;
	}

	/**
	 * 针对drag状态，在canDropOver()函数返回true的情况下，会调用该函数让我们去处理拖动换位置的流程
	 * 如果有位置变换返回true，否则发挥false
	 */
	public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target);

	/**
	 * 针对swipe状态，是否允许swipe(滑动)操作
	 */
	public boolean isItemViewSwipeEnabled() {
		return true;
	}

	/**
	 * 针对drag状态，当drag itemView和底下的itemView重叠的时候,可以给drag itemView设置额外的margin，让重叠更加容易发生。
	 * 相当于增大了drag itemView的区域
	 */
	public int getBoundingBoxMargin() {
		return 0;
	}

	/**
	 * 针对swipe状态，swipe滑动的位置超过了百分之多少就消失
	 */
	public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
		return .5f;
	}

	/**
	 * 针对drag状态，滑动超过百分之多少的距离可以可以调用onMove()函数(注意哦，这里指的是onMove()函数的调用，并不是随手指移动的那个view哦)
	 */
	public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
		return .5f;
	}

	/**
	 * 针对swipe状态，swipe的逃逸速度，换句话说就算没达到getSwipeThreshold设置的距离，达到了这个逃逸速度item也会被swipe消失掉
	 */
	public float getSwipeEscapeVelocity(float defaultValue) {
		return defaultValue;
	}

	/**
	 * 针对swipe状态，swipe滑动的阻尼系数,最大滑动速度
	 */
	public float getSwipeVelocityThreshold(float defaultValue) {
		return defaultValue;
	}

	/**
	 * 针对drag状态，在drag的过程中获取drag itemView底下对应的ViewHolder(一般不用我们处理直接super就好了)
	 */
	public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected,
													List<RecyclerView.ViewHolder> dropTargets,
													int curX,
													int curY) {
		return super.chooseDropTarget(selected, dropTargets, curX, curY);
	}

	/**
	 * 针对swipe状态，swipe 到达滑动消失的距离回调函数,一般在这个函数里面处理删除item的逻辑
	 * 确切的来讲是到达swipe item滑出屏幕动画结束的时候调用
	 */
	public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);


	/**
	 * 当onMove return true的时候调用(一般不用我们自己处理，直接super就好)
	 */
	public void onMoved(final RecyclerView recyclerView,
						final RecyclerView.ViewHolder viewHolder,
						int fromPos,
						final RecyclerView.ViewHolder target,
						int toPos,
						int x,
						int y) {
		super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
	}

	/**
	 * 针对swipe和drag状态，当一个item view在swipe、drag状态被释放的时候调用
	 * drag状态：当手指释放的时候会调用
	 * swipe状态：当item从RecyclerView中删除的时候调用，一般会在onSwiped()函数里面删除掉指定的item view
	 */
	public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
	}

	/**
	 * 针对swipe和drag状态，整个过程中一直会调用这个函数(和ItemDecoration里面的onDraw()函数对应)
	 */
	public void onChildDraw(Canvas c,
							RecyclerView recyclerView,
							RecyclerView.ViewHolder viewHolder,
							float dX,
							float dY,
							int actionState,
							boolean isCurrentlyActive) {
		super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
	}

	/**
	 * 针对swipe和drag状态，整个过程中一直会调用这个函数(和ItemDecoration里面的onDrawOver()函数对应)
	 * 这个函数提供给我们可以在RecyclerView的上面再绘制一层东西，比如绘制一层蒙层啥的
	 */
	public void onChildDrawOver(Canvas c,
								RecyclerView recyclerView,
								RecyclerView.ViewHolder viewHolder,
								float dX,
								float dY,
								int actionState,
								boolean isCurrentlyActive) {
		super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
	}

	/**
	 * 针对swipe和drag状态，当手指离开之后，view回到指定位置动画的持续时间(swipe可能是回到原位，也有可能是消失)
	 */
	public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
		return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
	}

	/**
	 * 针对drag状态，当itemView滑动到RecyclerView边界的时候(比如下面边界的时候),RecyclerView会scroll，
	 * 同时会调用该函数去获取scroller距离(不用我们处理 直接super)
	 */
	public int interpolateOutOfBoundsScroll(RecyclerView recyclerView,
											int viewSize,
											int viewSizeOutOfBounds,
											int totalSize,
											long msSinceStartScroll) {
		return super.interpolateOutOfBoundsScroll(recyclerView, viewSize, viewSizeOutOfBounds, totalSize, msSinceStartScroll);
	}

}
