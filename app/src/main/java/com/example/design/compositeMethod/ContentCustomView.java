package com.example.design.compositeMethod;

import android.util.Log;

public class ContentCustomView extends CustomView {
    public ContentCustomView(String name) {
        super(name);
    }

    @Override
    public void printView(String placeHolder) {
        Log.d("Composite", placeHolder + "--" + name);
    }
}
