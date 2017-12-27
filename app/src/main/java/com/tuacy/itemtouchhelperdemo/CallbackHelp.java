package com.tuacy.itemtouchhelperdemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by tuacy on 17-12-25.
 */

public abstract class CallbackHelp {

//	/**
//	 * 获取不同状态下可以移动的方向(idle:所有可以处理事件的方向swiping+dragging的方向, swiping:滑动的方向, dragging:拖拽的方向)
//	 * idle:0~7位
//	 * swiping:8~15位
//	 * dragging:16~23位
//	 */
//	public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);
//
//	/**
//	 * current holder是否可以拖动到target holder
//	 *
//	 * @return:是否可以拖动
//	 */
//	public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
//		return true;
//	}
//
//	/**
//	 * 在canDropOver()函数返回true的情况下，会调用该函数让我们去处理拖动换位子的流程，从旧位置拖动到新位置
//	 *
//	 * @return　是否处理了拖动
//	 */
//	public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target);
//
//	/**
//	 * 当RecyclerView的item长按的时候是否允许进入dragging(拖拽)的状态
//	 *
//	 * @return　是否允许进入dragging的状态
//	 */
//	public boolean isLongPressDragEnabled() {
//		return true;
//	}
//
//	/**
//	 * 是否允许swiping(滑动)操作
//	 *
//	 * @return 是否允许swiping(滑动)操作
//	 */
//	public boolean isItemViewSwipeEnabled() {
//		return true;
//	}
//
//	/**
//	 * 当dragging itemView和底下的itemView重叠的时候,可以给dragging itemView设置额外的margin，这样可以达到不完全重叠的情况
//	 *
//	 * @return　dragging itemView额外的margin
//	 */
//	public int getBoundingBoxMargin() {
//		return 0;
//	}
//
//	/**
//	 * swiping滑动的位置超过了百分值多少就消失
//	 *
//	 * @param viewHolder: swiping item holder
//	 * @return 百分比
//	 */
//	public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
//		return .5f;
//	}
//
//	/**
//	 * 滑动百分之多少的距离，进入dragging状态
//	 *
//	 * @param viewHolder: dragging item holder
//	 * @return 百分比
//	 */
//	public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
//		return .5f;
//	}
//
//	/**
//	 * swiping的逃逸速度，换句话说只有达到了这个速度才会进入swiping状态
//	 *
//	 * @return 逃逸速度
//	 */
//	public float getSwipeEscapeVelocity(float defaultValue) {
//		return defaultValue;
//	}
//
//	/**
//	 * swiping滑动的阻尼系数
//	 *
//	 * @return swiping滑动的阻尼系数
//	 */
//	public float getSwipeVelocityThreshold(float defaultValue) {
//		return defaultValue;
//	}
//
//	/**
//	 * 在drag的过程中获取drag itemView底下对应的ViewHolder(不用我们处理)
//	 *
//	 * @return target ViewHolder
//	 */
//	public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected,
//													List<RecyclerView.ViewHolder> dropTargets,
//													int curX,
//													int curY) {
//	}
//
//	/**
//	 * swipe 到达滑动消失的距离回调函数
//	 *
//	 * @param viewHolder:swipe itemView 对应的viewHolder
//	 */
//	public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);
//
//	/**
//	 * 当swipe或者drag对应的ViewHolder改变的时候调用(这个函数不用我们处理)
//	 */
//	public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
//		if (viewHolder != null) {
//			sUICallback.onSelected(viewHolder.itemView);
//		}
//	}
//
//	/**
//	 * 当onMove return true的时候调用(这个也不用我们去处理)
//	 */
//	public void onMoved(final RecyclerView recyclerView,
//						final RecyclerView.ViewHolder viewHolder,
//						int fromPos,
//						final RecyclerView.ViewHolder target,
//						int toPos,
//						int x,
//						int y) {
//	}
//
//	/**
//	 * 与元素的用户交互已经结束的时候调用
//	 */
//	public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//	}
//
//	/**
//	 * swipe 或者 drag过程中会一直调用这个方法去绘制RecyclerView的item
//	 */
//	public void onChildDraw(Canvas c,
//							RecyclerView recyclerView,
//							RecyclerView.ViewHolder viewHolder,
//							float dX,
//							float dY,
//							int actionState,
//							boolean isCurrentlyActive) {
//	}
//
//	/**
//	 * 这个函数提供给我们可以在RecyclerView的上面再绘制一层东西，比如绘制一层蒙层啥的
//	 */
//	public void onChildDrawOver(Canvas c,
//								RecyclerView recyclerView,
//								RecyclerView.ViewHolder viewHolder,
//								float dX,
//								float dY,
//								int actionState,
//								boolean isCurrentlyActive) {
//	}
//
//	/**
//	 * 设置手指离开之后，动画的持续时间
//	 */
//	public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
//	}
//
//	/**
//	 * 当itemView滑动到RecyclerView边界的时候(比如下面边界的时候),RecyclerView会scroll，同时会调用该函数
//	 */
//	public int interpolateOutOfBoundsScroll(RecyclerView recyclerView,
//											int viewSize,
//											int viewSizeOutOfBounds,
//											int totalSize,
//											long msSinceStartScroll) {
//	}

}
