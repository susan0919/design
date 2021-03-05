package com.example.design.factoryMethod;

import android.util.Log;

public class AliPay extends PayChannel {
    @Override
    public void pay(String price) {
        Log.d("Factory", "吊起支付宝SDK，价格：" + price);
    }
}
