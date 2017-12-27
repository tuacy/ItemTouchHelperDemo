package com.tuacy.itemdecoration.space;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuacy.itemdecoration.R;

import java.util.ArrayList;
import java.util.List;

public class ItemDecorationSpaceActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, ItemDecorationSpaceActivity.class));
	}

	private Context      mContext;
	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_decoration_space);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_item_decoration_padding);
		GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
		mRecyclerView.setLayoutManager(layoutManager);
	}

	private void initEvent() {

	}

	private void initData() {
		ItemSpaceAdapter adapter = new ItemSpaceAdapter(obtainData());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.addItemDecoration(new ItemDecorationSpace(20, 20));
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
