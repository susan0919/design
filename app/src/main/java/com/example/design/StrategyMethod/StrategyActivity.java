package com.example.design.StrategyMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;
import com.example.design.TemplateMethod.AbstractClass;
import com.example.design.TemplateMethod.ConcreteClass;

public class StrategyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
    }

    public void onStrategyTest(View view) {
    }
}
