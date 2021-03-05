package com.example.design.factoryMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class FactoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
    }

    public void onFactoryTest(View view) {
        PayChannel payChannel = PayFactory.getPayChannel("wechat");
        payChannel.pay("100元");

        payChannel = PayFactory.getEasyPaychannel(AliPay.class);
        payChannel.pay("300元");

    }
}
