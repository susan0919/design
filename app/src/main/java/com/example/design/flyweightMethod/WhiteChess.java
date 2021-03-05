package com.example.design.flyweightMethod;

import android.util.Log;

public class WhiteChess extends Chessman {
    public WhiteChess() {
        super("。");
        Log.d("Flyweight", "-------- WhiteChess construction is exec ");
    }

    @Override
    public void point(int x, int y) {
        this.x = x;
        this.y = y;
        show();
    }
}
