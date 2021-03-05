package com.example.design.compositeMethod;

import android.util.Log;

public class ViewGoup extends View {
    public ViewGoup(String name) {
        super(name);
    }

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        views.remove(view);
    }

    @Override
    public void printView(String placeHolder) {
        Log.d("Composite", placeHolder + "└──" + name);
        for (View view : views) {
            view.printView(placeHolder+"  ");
        }
    }
}
