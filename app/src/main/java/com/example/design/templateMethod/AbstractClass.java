package com.example.design.templateMethod;

import android.util.Log;

public abstract class AbstractClass {
    public void TemplateMethod() {
        specialMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specialMethod() {
        Log.d("Template", "抽象类中的具体方法被调用");
    }

    public abstract void abstractMethod1();

    public abstract void abstractMethod2();
}
