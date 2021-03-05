package com.example.design.flyweightMethod;

import android.util.Log;

public abstract class Chessman {
    protected int x, y;
    protected String chess;

    public Chessman(String chess) {
        this.chess = chess;
    }

    public abstract void point(int x, int y);

    public void show() {
        Log.d("Flyweight", this.chess + "(" + this.x + "," + this.y + ")");
    }

}
