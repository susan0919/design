package com.example.design.compositeMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class CompositeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composite);
    }

    public void onCompositeTest(View view) {
        ViewGoup rootView = new ViewGoup("LinearLayout");
        ViewGoup frameView = new ViewGoup("FrameLayout");
        ContentView textView = new ContentView("TextView");
        ContentView button = new ContentView("Button");
        ContentView label = new ContentView("Label");
        rootView.addView(frameView);
        rootView.addView(textView);
        frameView.addView(button);
        frameView.addView(label);
        rootView.printView("");
    }
}
