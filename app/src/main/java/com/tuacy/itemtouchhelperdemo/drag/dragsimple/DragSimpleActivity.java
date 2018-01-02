package com.tuacy.itemtouchhelperdemo.drag.dragsimple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.tuacy.itemtouchhelperdemo.R;
import com.tuacy.itemtouchhelperdemo.drag.DragCallback;
import com.tuacy.itemtouchhelperdemo.drag.DragHelper;
import com.tuacy.itemtouchhelperdemo.utls.ApkInfo;
import com.tuacy.itemtouchhelperdemo.utls.ApkUtil;

import java.util.List;


public class DragSimpleActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, DragSimpleActivity.class));
	}

	private Context           mContext;
	private Handler           mMainHandler;
	private RecyclerView      mRecyclerView;
	private DragSimpleAdapter mAdapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drag_change);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_drag_simple);
		GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.addItemDecoration(new SpaceItemDecoration());
		DragCallback dragCallback = new DragCallback(mDragHelper);
		ItemTouchHelper touchHelper = new ItemTouchHelper(dragCallback);
		touchHelper.attachToRecyclerView(mRecyclerView);
	}

	private void initEvent() {

	}

	private void initData() {
		mAdapter = new DragSimpleAdapter();
		mRecyclerView.setAdapter(mAdapter);

		new Thread() {
			@Override
			public void run() {
				super.run();
				final List<ApkInfo> apkList = ApkUtil.getApkList(mContext.getPackageManager());
				getMainHandler().post(new Runnable() {
					@Override
					public void run() {
						mAdapter.setData(apkList);
					}
				});
			}
		}.start();
	}

	protected Handler getMainHandler() {
		if (mMainHandler == null) {
			mMainHandler = new Handler(Looper.getMainLooper());
		}
		return mMainHandler;
	}

	private DragHelper mDragHelper = new DragHelper() {
		@Override
		public void onDragStart() {

		}

		@Override
		public void onDragEnd() {

		}

		@Override
		public void onDragPositionChange(int fromPosition, int toPosition) {
			mAdapter.notifyItemMoved(fromPosition, toPosition);
		}
	};
}
