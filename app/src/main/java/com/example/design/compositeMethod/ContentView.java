package com.example.design.compositeMethod;

import android.util.Log;

public class ContentView extends View {
    public ContentView(String name) {
        super(name);
    }

    @Override
    public void printView(String placeHolder) {
        Log.d("Composite", placeHolder + "--" + name);
    }
}
