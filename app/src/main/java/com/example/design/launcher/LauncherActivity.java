package com.example.design.launcher;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.design.R;
import com.example.design.launcher.adapter.ViewPagerFragmentAdapter;
import com.example.design.launcher.fragment.AppRecyclerViewFragment;
import com.example.design.launcher.fragment.SecondMenuFragment;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    public ViewPager viewPager;
    public ViewPagerFragmentAdapter fragmentAdapter;
    public List<Fragment> fragmentList;
    public SecondMenuFragment secondMenuFragment;
    public AppRecyclerViewFragment appMenuFragment;
    public AppRecyclerViewFragment appRecyclerViewFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();

    }

    private void initView() {
        secondMenuFragment = new SecondMenuFragment();
        appMenuFragment = new AppRecyclerViewFragment();
        appRecyclerViewFragment = new AppRecyclerViewFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(secondMenuFragment);
        fragmentList.add(appMenuFragment);
        fragmentList.add(appRecyclerViewFragment);

        viewPager = findViewById(R.id.container);
        Log.d("wendan", "viewPager = " + viewPager);
        fragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.setFragmentList(fragmentList);
        viewPager.setAdapter(fragmentAdapter);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
