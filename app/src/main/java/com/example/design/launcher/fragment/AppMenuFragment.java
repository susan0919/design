package com.example.design.launcher.fragment;

import android.view.View;

import com.example.design.R;
import com.example.design.launcher.base.LazyLoadFragment;
import com.example.design.launcher.view.AppMenuView;

public class AppMenuFragment extends LazyLoadFragment {

    public AppMenuView appMenuView;

    @Override
    public void fetchData() {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_app_menu_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void injectPresenter() {

    }

    @Override
    protected void initData() {

    }
}
