package com.example.design.launcher.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import java.util.List;

public class PackageUtils {

    public static List<PackageInfo> getInstalledApps(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> list = packageManager.getInstalledPackages(0);
        return list;
    }

    public static String getTitle(String packageName, Context context) {
        if (context == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            return (applicationInfo.loadLabel(packageManager)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Drawable getIconDrawable(String packageName, Context context) {
        if (context == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            return applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Drawable getIconPressedDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        drawable.mutate().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        return drawable;
    }

}
