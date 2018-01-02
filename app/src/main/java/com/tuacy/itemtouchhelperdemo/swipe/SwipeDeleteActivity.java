package com.tuacy.itemtouchhelperdemo.swipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.tuacy.itemtouchhelperdemo.R;

import java.util.ArrayList;
import java.util.List;


public class SwipeDeleteActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, SwipeDeleteActivity.class));
	}

	private Context             mContext;
	private RecyclerView        mRecyclerView;
	private SwipeDeleteAdapter  mAdapter;
	private ItemTouchHelper mItemTouchHelper;
	private List<String>        mDataList;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drag_delete);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_drag_delete);
		LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
		mRecyclerView.setLayoutManager(layoutManager);
	}

	private void initEvent() {

	}

	private void initData() {
		mAdapter = new SwipeDeleteAdapter(mDataList = obtainData());
		mRecyclerView.setAdapter(mAdapter);
		mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
			@Override
			public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
				return false;
			}

			@Override
			public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
				mDataList.remove(viewHolder.getAdapterPosition());
				mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
			}

			@Override
			public void onChildDraw(Canvas c,
									RecyclerView recyclerView,
									RecyclerView.ViewHolder viewHolder,
									float dX,
									float dY,
									int actionState,
									boolean isCurrentlyActive) {
				super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
				if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
					//滑动时改变Item的透明度
					final float alpha = 1 - Math.abs(dX) / (float)viewHolder.itemView.getWidth();
					viewHolder.itemView.setAlpha(alpha);
				}
			}
		});
		mItemTouchHelper.attachToRecyclerView(mRecyclerView);
	}

	private List<String> obtainData() {
		List<String> dataList = new ArrayList<>();
		dataList.add("南昌");
		dataList.add("赣州");
		dataList.add("宜春");
		dataList.add("九江");
		dataList.add("上饶");
		dataList.add("萍乡");
		dataList.add("抚州");
		dataList.add("新余");
		return dataList;
	}
}
