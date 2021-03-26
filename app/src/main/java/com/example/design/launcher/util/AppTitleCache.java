package com.example.design.launcher.util;


import android.content.Context;

import java.util.HashMap;

public class AppTitleCache {
    private Context context;
    private HashMap<String, String> titleMap = new HashMap<>();
    private static AppTitleCache instance;

    private AppTitleCache(Context context) {
        this.context = context;
    }

    public static AppTitleCache getInstance(Context context) {
        if (instance == null) {
            instance = new AppTitleCache(context);
        }
        return instance;
    }

    public String getTitle(String packageName) {
        return this.titleMap.get(packageName);
    }

    public boolean contain(String packageName) {
        return this.titleMap.containsKey(packageName);
    }

    public void saveTitle(String packageName, String title) {
        this.titleMap.put(packageName, title);
    }

    public void destroy() {
        instance = null;
    }

    public String generateAppTitle(String packageName, Context context) {
        if (packageName == null) {
            return "";
        }
        String name = "";
        name = PackageUtils.getTitle(packageName, this.context);
        return name;
    }
}
