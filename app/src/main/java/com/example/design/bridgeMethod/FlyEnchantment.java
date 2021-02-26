package com.example.design.bridgeMethod;

import android.util.Log;

public class FlyEnchantment implements IEnchantment {
    @Override
    public void onActivate() {
        Log.d("Bridge", "The item begins to glow faintly.");
    }

    @Override
    public void apply() {
        Log.d("Bridge", "The item flies and strikes the enemies finally returning to owner's hand.");
    }

    @Override
    public void onDeactivate() {
        Log.d("Bridge", "The item's glow fades.");
    }
}
