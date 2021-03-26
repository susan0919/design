package com.example.design.launcher.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.launcher.adapter.AppListAdapter;
import com.example.design.launcher.base.LazyLoadFragment;
import com.example.design.launcher.presenter.AppListPresenter;
import com.example.design.launcher.view.IAppListView;

import java.util.List;

public class AppMenuFragment extends LazyLoadFragment implements IAppListView {
    private RecyclerView recyclerView;
    private AppListPresenter presenter;
    private AppListAdapter appListAdapter;

    @Override
    public void fetchData() {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_app_menu_layout;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.app_list);
        presenter = new AppListPresenter(this, getContext());
        List<String> list = presenter.getAppList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        appListAdapter = new AppListAdapter(getContext());
        appListAdapter.setAppList(list);
        recyclerView.setAdapter(appListAdapter);

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

    @Override
    public void updateAppListView(List<String> data) {
        if (isVisibleToUser) {
            appListAdapter.setAppList(presenter.getAppList());
            notifyAll();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
