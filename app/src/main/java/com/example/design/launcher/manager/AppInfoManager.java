package com.example.design.launcher.manager;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.example.design.launcher.dao.AppInfo;
import com.example.design.launcher.dao.HomeAppInfo;

import java.util.ArrayList;
import java.util.List;

public class AppInfoManager {
    private static final String TAG = AppInfoManager.class.getSimpleName();
    private Context context;
    public AppInfoManager instance;
    private DataBaseManager dataBaseManager;

    public List<AppInfo> apps = new ArrayList<>();

    public AppInfoManager getInstance(Context context) {
        if (instance == null) {
            instance = new AppInfoManager(context);
        }
        return instance;
    }

    private AppInfoManager(Context context) {
        this.context = context;
        dataBaseManager = new DataBaseManager(context);
        loadAllApps();
    }

    private void loadAllApps() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                apps.clear();
                List<Integer> toBeDeleted = new ArrayList<>();
                List<AppInfo> dbApps = dataBaseManager.queryAllAppInfoList();
                List<PackageInfo> installApps = context.getPackageManager().getInstalledPackages(0);
                for (int i = 0; i < dbApps.size(); i++) {
                    AppInfo dbApp = dbApps.get(i);
                    boolean found = false;
                    for (PackageInfo packageInfo : installApps) {
                        if (packageInfo.packageName.equals(dbApp.getPackageName())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        dataBaseManager.deleteInAll(dbApp);
                        toBeDeleted.add(i);

                        for (AppInfo homeAppInfo : apps) {
                            if (homeAppInfo.getPackageName().equals(dbApp.getPackageName())) {
                                apps.remove(homeAppInfo);
                                break;
                            }
                        }
                    }
                }
                if (toBeDeleted.size() != 0) {
                    dbApps.remove(toBeDeleted);
                }


            }
        });

        thread.start();
    }

    private AppInfo generatePackeToAppInfo(PackageInfo packageInfo) {
        AppInfo appInfo = new AppInfo();
        appInfo.setPackageName(packageInfo.packageName);
        return appInfo;
    }


    public void destroy() {
        instance = null;
    }
}
