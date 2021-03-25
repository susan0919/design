package com.example.design.templateMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class TemplateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
    }

    public void onTemplateTest(View view) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.TemplateMethod();
    }
}
