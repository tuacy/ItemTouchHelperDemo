package com.tuacy.itemtouchhelperdemo.utls;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


import java.util.ArrayList;
import java.util.List;

public class ApkUtil {

	public static List<ApkInfo> getApkList(PackageManager packageManager) {
		List<ApkInfo> apkInfoList = new ArrayList<>();
		try {
			List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
			for (int i = 0; i < packageInfoList.size(); i++) {
				PackageInfo packageInfo = packageInfoList.get(i);
				ApkInfo apkInfo = new ApkInfo();
				apkInfo.setApkName(packageInfo.packageName);
				if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
					continue;
				}
				apkInfo.setImage(packageInfo.applicationInfo.loadIcon(packageManager));
				apkInfoList.add(apkInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apkInfoList;
	}

}
