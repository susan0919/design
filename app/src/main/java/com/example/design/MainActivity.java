package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doBridgeMethod(View view) {
        startActivity(new Intent("android.intent.action.BRIDGE"));
    }

    public void doDecoratorMethod(View view) {
        startActivity(new Intent("android.intent.action.DECORATOR"));
    }
}
