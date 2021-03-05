package com.example.design.StrategyMethod;

import android.util.Log;

public class ConcreteStrategyB implements Strategy {
    @Override
    public void StragtegyMethod() {
        Log.d("Strategy","具体策略B的策略方法被访问！");
    }
}
