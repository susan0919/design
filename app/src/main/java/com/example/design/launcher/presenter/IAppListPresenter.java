package com.example.design.launcher.presenter;

import java.util.List;

public interface IAppListPresenter {
    List<String> getAppList();

    void destroy();
}
