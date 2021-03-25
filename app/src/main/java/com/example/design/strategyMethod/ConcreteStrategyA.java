package com.example.design.strategyMethod;

import android.util.Log;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void StragtegyMethod() {
        Log.d("Strategy", "具体策略A的策略方法被访问！");
    }
}
