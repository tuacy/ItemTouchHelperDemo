package com.tuacy.itemdecoration.divider;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tuacy.itemdecoration.R;

public class ItemDecorationDividerActivity extends AppCompatActivity{

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, ItemDecorationDividerActivity.class));
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_decoration_divider);
	}
}
