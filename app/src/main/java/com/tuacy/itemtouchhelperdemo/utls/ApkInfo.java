package com.tuacy.itemtouchhelperdemo.utls;


import android.graphics.drawable.Drawable;

public class ApkInfo {

	private Drawable mImage;
	private String   mApkName;

	public Drawable getImage() {
		return mImage;
	}

	public void setImage(Drawable image) {
		mImage = image;
	}

	public String getApkName() {
		return mApkName;
	}

	public void setApkName(String apkName) {
		mApkName = apkName;
	}
}
