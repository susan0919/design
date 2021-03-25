package com.example.design.launcher.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Message;

import com.example.design.launcher.dao.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class AppInfoManager {
    private static final String TAG = AppInfoManager.class.getSimpleName();
    private Context context;
    public AppInfoManager instance;
    private DataBaseManager dataBaseManager;

    private static final int MSG_APP_INITED = 0;
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

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_APP_INITED:
                    break;
                default:
                    //do nothing
                    break;
            }
        }
    };

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

                //save app to database
                for (PackageInfo packageInfo : installApps) {
                    boolean found = false;

                    for (AppInfo appInfo : dbApps) {
                        if (appInfo.getPackageName().equals(packageInfo.packageName)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        AppInfo app = new AppInfo();
                        app.setPackageName(packageInfo.packageName);
                        app.setPosition(apps.size());
                        dataBaseManager.insertInAll(app);
                        apps.add(app);
                    }
                }
                handler.sendEmptyMessage(MSG_APP_INITED);

            }
        });

        thread.start();
    }

    private AppInfo generatePackeToAppInfo(PackageInfo packageInfo) {
        AppInfo appInfo = new AppInfo();
        appInfo.setPackageName(packageInfo.packageName);
        return appInfo;
    }

    public List<AppInfo> getApps() {
        return apps;
    }

    public void destroy() {
        instance = null;
        dataBaseManager.destroy();
        apps.clear();
    }
}