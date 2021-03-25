package com.example.design.stateMethod;

import android.util.Log;

public class LoginState implements UserState {
    @Override
    public void pay() {
        Log.d("State", " 进行支付");
    }

    @Override
    public void editMessage() {
        Log.d("State", " 编辑个人资料");
    }

    @Override
    public void share() {
        Log.d("State", " 进行分享");
    }
}
