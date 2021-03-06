package com.example.design.decoratorMethod;

import android.util.Log;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        Log.d("Decorator", "为具体构件角色增加额外的功能addedFunction()");
    }
}
