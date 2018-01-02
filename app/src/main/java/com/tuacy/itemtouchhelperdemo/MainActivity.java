package com.tuacy.itemtouchhelperdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tuacy.itemtouchhelperdemo.drag.DragChangeActivity;
import com.tuacy.itemtouchhelperdemo.swipe.SwipeDeleteActivity;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		findViewById(R.id.layout_swipe_delete).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SwipeDeleteActivity.startUp(mContext);
			}
		});
		findViewById(R.id.layout_drag_change_position).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DragChangeActivity.startUp(mContext);
			}
		});
	}
}
