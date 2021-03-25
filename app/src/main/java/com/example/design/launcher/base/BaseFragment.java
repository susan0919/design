package com.example.design.launcher.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private View cardView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cardView = View.inflate(getActivity(), layoutId(), null);
        cardView.setBackgroundColor(Color.TRANSPARENT);
        initView(cardView);
        setListener();
       return cardView;
    }

    protected abstract int layoutId();

    protected abstract void initView(View view);

    protected abstract void setListener();

    protected abstract void injectPresenter();

    protected abstract void initData();
}
