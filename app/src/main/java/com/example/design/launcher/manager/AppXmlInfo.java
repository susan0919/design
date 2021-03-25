package com.example.design.launcher.manager;

import androidx.annotation.NonNull;

import com.example.design.launcher.dao.AppInfo;

public class AppXmlInfo extends AppInfo {
    private boolean isHome;

    public AppXmlInfo() {
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    @NonNull
    @Override
    public String toString() {
        return "AppXmlInfo{" +
                "isHome = " + isHome +
                "packageName = " + getPackageName() +
                "}";
    }
}
