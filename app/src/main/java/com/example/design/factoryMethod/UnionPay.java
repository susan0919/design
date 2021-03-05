package com.example.design.factoryMethod;

import android.util.Log;

public class UnionPay extends PayChannel {
    @Override
    public void pay(String price) {
        Log.d("Factory", "调起银联SDK，价格：" + price);
    }
}
