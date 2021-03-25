package com.example.design.templateMethod;

import android.util.Log;

public class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        Log.d("Template", "抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        Log.d("Template", "抽象方法2的实现被调用");
    }
}
