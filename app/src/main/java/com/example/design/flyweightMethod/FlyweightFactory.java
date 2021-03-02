package com.example.design.flyweightMethod;

import android.util.Log;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
    private Map<String, Flyweight> map = new ConcurrentHashMap<String, Flyweight>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = map.get(key);
        if (flyweight != null) {
            Log.d("Flyweight", "具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            map.put(key, flyweight);
        }
        return flyweight;
    }
}
