package com.tuacy.itemtouchhelperdemo.drag;


public interface DragHelper {

	/**
	 * drag 开始
	 */
	void onDragStart();

	/**
	 * drag 结束
	 */
	void onDragEnd();


	/**
	 * 变换位置
	 */
	void onDragPositionChange(int fromPosition, int toPosition);
}
