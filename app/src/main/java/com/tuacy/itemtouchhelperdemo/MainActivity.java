package com.tuacy.itemtouchhelperdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tuacy.itemtouchhelperdemo.dragchange.DragChangeActivity;
import com.tuacy.itemtouchhelperdemo.dragdelete.DragDeleteActivity;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		findViewById(R.id.layout_slide_delete).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DragDeleteActivity.startUp(mContext);
			}
		});
		findViewById(R.id.layout_slide_change_position).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DragChangeActivity.startUp(mContext);
			}
		});
	}
}
