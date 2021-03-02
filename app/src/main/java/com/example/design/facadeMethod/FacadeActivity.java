package com.example.design.facadeMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class FacadeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facade);
    }

    public void onFacadeTest(View view) {
        Facade facade = new Facade();
        facade.method();

    }
}
