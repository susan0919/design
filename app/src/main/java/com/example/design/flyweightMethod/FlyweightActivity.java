package com.example.design.flyweightMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class FlyweightActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyweight);
    }

    public void onFlyweightTest(View view) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight f0 = flyweightFactory.getFlyweight("a");
        Flyweight f1 = flyweightFactory.getFlyweight("a");
        Flyweight f2 = flyweightFactory.getFlyweight("b");
        Flyweight f3 = flyweightFactory.getFlyweight("a");
        Flyweight f4 = flyweightFactory.getFlyweight("b");

        f0.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
        f1.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
        f2.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
        f3.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
        f4.operation(new UnsharedConcreteFlyweight("第2次调用a。"));

    }
}
