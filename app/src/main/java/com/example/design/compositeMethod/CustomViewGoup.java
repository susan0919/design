package com.example.design.compositeMethod;

import android.util.Log;

public class CustomViewGoup extends CustomView {
    public CustomViewGoup(String name) {
        super(name);
    }

    public void addView(CustomView view) {
        views.add(view);
    }

    public void removeView(CustomView view) {
        views.remove(view);
    }

    @Override
    public void printView(String placeHolder) {
        Log.d("Composite", placeHolder + "└──" + name);
        for (CustomView view : views) {
            view.printView(placeHolder+"  ");
        }
    }
}
