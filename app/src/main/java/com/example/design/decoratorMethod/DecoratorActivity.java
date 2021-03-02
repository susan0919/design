package com.example.design.decoratorMethod;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.design.R;

public class DecoratorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
    }

    public void onDecoratorTest(View view) {
        Component component = new ConcreteComponet();
        component.operation();
        Log.d("Decorator", "---------------------");
        Component d = new ConcreteDecorator(component);
        d.operation();

    }

    public void onMakeEspresso(View view) {
        Beverage beverage = new Espresso();
        Log.d("Decorator", "Description:" + beverage.getDescription() + ";cost:" + beverage.cost());

    }

    public void onMakeMochaWhip(View view) {
        Beverage beverage = new DarkBeverage();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        Log.d("Decorator", "Description:" + beverage.getDescription() + ";cost:" + beverage.cost());
    }
}
