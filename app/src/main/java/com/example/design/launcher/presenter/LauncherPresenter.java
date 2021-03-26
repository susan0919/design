package com.example.design.launcher.presenter;

import android.content.Context;

import com.example.design.launcher.manager.AppInfoManager;
import com.example.design.launcher.manager.IAppListChangeListener;
import com.example.design.launcher.view.IAppListView;

import java.util.List;

public class LauncherPresenter implements IAppList, IAppListChangeListener {
    private List<String> appList;
    private AppInfoManager appInfoManager;
    private IAppListView launcherView;

    public LauncherPresenter(IAppListView launcherView, Context context) {
        this.launcherView = launcherView;
        appInfoManager = AppInfoManager.getInstance(context);
    }

    @Override
    public List<String> getAppList() {
        return appInfoManager.getApps();
    }

    @Override
    public void destroy() {
        appInfoManager.destroy();

    }

    @Override
    public void onAppListChanged(List<String> list) {
        if (launcherView != null) {
            launcherView.updateAppListView(list);
        }
    }
}
