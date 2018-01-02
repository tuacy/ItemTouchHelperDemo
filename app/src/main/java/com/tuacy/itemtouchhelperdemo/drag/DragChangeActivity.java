package com.tuacy.itemtouchhelperdemo.drag;

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
import com.tuacy.itemtouchhelperdemo.utls.ApkUtil;

import java.util.List;


public class DragChangeActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, DragChangeActivity.class));
	}

	private Context           mContext;
	private Handler           mMainHandler;
	private RecyclerView      mRecyclerView;
	private DragChangeAdapter mAdapter;

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
		mRecyclerView = findViewById(R.id.recycler_drag_change);
		GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.addItemDecoration(new SpaceItemDecoration());
		ItemPositionChangeCallback itemPositionChangeCallback = new ItemPositionChangeCallback(mItemPositionChangeHelper);
		ItemTouchHelper touchHelper = new ItemTouchHelper(itemPositionChangeCallback);
		touchHelper.attachToRecyclerView(mRecyclerView);
	}

	private void initEvent() {

	}

	private void initData() {
		mAdapter = new DragChangeAdapter();
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

	private ItemPositionChangeHelper mItemPositionChangeHelper = new ItemPositionChangeHelper() {
		@Override
		public void onItemPositionChange(int fromPosition, int toPosition) {
			mAdapter.notifyItemMoved(fromPosition, toPosition);
		}
	};
}
