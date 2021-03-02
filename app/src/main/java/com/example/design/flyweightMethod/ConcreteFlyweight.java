package com.example.design.flyweightMethod;

import android.util.Log;

public class ConcreteFlyweight implements Flyweight {
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        Log.d("Flyweight", "具体的享元" + key + "正在创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        Log.d("Flyweight", "具体的享元" + key + "被调用");
        Log.d("Flyweight", "非享元信息是" + state.getInfo());
    }
}
