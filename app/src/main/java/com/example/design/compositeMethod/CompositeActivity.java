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
        CustomViewGoup rootView = new CustomViewGoup("LinearLayout");
        CustomViewGoup frameView = new CustomViewGoup("FrameLayout");
        ContentCustomView textView = new ContentCustomView("TextView");
        ContentCustomView button = new ContentCustomView("Button");
        ContentCustomView label = new ContentCustomView("Label");
        rootView.addView(frameView);
        rootView.addView(textView);
        frameView.addView(button);
        frameView.addView(label);
        rootView.printView("");
    }
}
