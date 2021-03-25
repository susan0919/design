package com.example.design.launcher.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class PackageUtils {

    public static List<PackageInfo> getInstalledApps(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> list = packageManager.getInstalledPackages(0);
        return list;

    }
}
