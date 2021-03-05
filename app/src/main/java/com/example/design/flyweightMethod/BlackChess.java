package com.example.design.flyweightMethod;

import android.util.Log;

public class BlackChess extends Chessman {
    public BlackChess() {
        super(".");
        Log.d("Flyweight", "-------BlackChess construction exec");
    }

    @Override
    public void point(int x, int y) {
        this.x = x;
        this.y = y;
        show();
    }
}
