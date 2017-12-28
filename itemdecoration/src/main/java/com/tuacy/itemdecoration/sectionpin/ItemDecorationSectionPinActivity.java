package com.tuacy.itemdecoration.sectionpin;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuacy.itemdecoration.R;
import com.tuacy.itemdecoration.space.ItemSpaceAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemDecorationSectionPinActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, ItemDecorationSectionPinActivity.class));
	}

	private Context      mContext;
	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_decoration_section_pin);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_item_decoration_padding);
		LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
		mRecyclerView.setLayoutManager(layoutManager);
	}

	private void initEvent() {

	}

	private void initData() {
		PinAdapter adapter = new PinAdapter(obtainData());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.addItemDecoration(new ItemDecorationSectionPin());
	}

	private List<String> obtainData() {
		List<String> list = new ArrayList<>();
		list.add("2016-07-20");
		list.add("萍乡");
		list.add("高安");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-21");
		list.add("江西");
		list.add("南昌");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-22");
		list.add("中国");
		list.add("北京");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-23");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-24");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-25");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-26");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-27");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-28");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-29");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-30");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		list.add("2016-07-21");
		list.add("辽宁");
		list.add("沈阳");
		list.add("江西");
		list.add("南昌");
		return list;
	}
}
