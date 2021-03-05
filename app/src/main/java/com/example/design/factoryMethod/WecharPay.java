package com.example.design.factoryMethod;

import android.util.Log;

public class WecharPay extends PayChannel {
    @Override
    public void pay(String price) {
        Log.d("Factory", "调起微信SDK，价格：" + price);
    }
}
