package com.tuacy.itemdecoration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tuacy.itemdecoration.divider.ItemDecorationDividerActivity;
import com.tuacy.itemdecoration.sectionpin.ItemDecorationSectionPinActivity;
import com.tuacy.itemdecoration.space.ItemDecorationSpaceActivity;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		findViewById(R.id.layout_item_decoration_padding).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ItemDecorationSpaceActivity.startUp(mContext);
			}
		});
		findViewById(R.id.layout_item_decoration_divider).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ItemDecorationDividerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.layout_item_decoration_section_pin).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ItemDecorationSectionPinActivity.startUp(mContext);
			}
		});
	}
}
