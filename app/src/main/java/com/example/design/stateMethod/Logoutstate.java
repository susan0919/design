package com.example.design.stateMethod;

import android.util.Log;

public class Logoutstate implements UserState {
    @Override
    public void pay() {
        Log.d("State", " 去登陆");
    }

    @Override
    public void editMessage() {
        Log.d("State", " 去登陆");
    }

    @Override
    public void share() {
        Log.d("State", " 去登陆");
    }
}
