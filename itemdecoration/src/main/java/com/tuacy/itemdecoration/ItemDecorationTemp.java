package com.tuacy.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class ItemDecorationTemp {

	/**
	 * 可以通过重写这个函数给RecyclerView绘制任意合适的decorations(装饰)
	 * 会在RecyclerView item绘制之前绘制。可以认为是绘制在RecyclerView的下面
	 * 会在RecyclerView类的onDraw()里面调用
	 */
	public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
		onDraw(c, parent);
	}

	/**
	 * deprecated掉的函数我们不管，忽视掉，不建议使用了
	 */
	@Deprecated
	public void onDraw(Canvas c, RecyclerView parent) {
	}

	/**
	 * 可以通过重写这个函数给RecyclerView绘制任意合适的decorations(装饰)
	 * 会在RecyclerView item绘制之后绘制。可以认为是绘制在RecyclerView的上面(在上面在盖一层)
	 * 会在RecyclerView类的super.draw()之后调用,
	 */
	public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
		onDrawOver(c, parent);
	}

	/**
	 * deprecated掉的函数不建议使用了，忽视掉
	 */
	@Deprecated
	public void onDrawOver(Canvas c, RecyclerView parent) {
	}


	/**
	 * deprecated掉的函数不建议使用了，忽视掉
	 */
	@Deprecated
	public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
		outRect.set(0, 0, 0, 0);
	}

	/**
	 * 给RecyclerView　item对应的每个view增加一些offsets(你可以这么认为item对应的view外面还有一层布局，给这个布局增加padding)
	 */
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		getItemOffsets(outRect, ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), parent);
	}

}
