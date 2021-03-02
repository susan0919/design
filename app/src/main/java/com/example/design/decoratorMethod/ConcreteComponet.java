package com.example.design.decoratorMethod;

import android.util.Log;

public class ConcreteComponet implements Component {

    public ConcreteComponet() {
        Log.d("Decorator", "创建具体构建角色");
    }

    @Override
    public void operation() {
        Log.d("Decorator", "调用具体构建角色的operation方法");
    }
}
