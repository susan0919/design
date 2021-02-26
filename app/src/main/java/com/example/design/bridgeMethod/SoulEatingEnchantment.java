package com.example.design.bridgeMethod;

import android.util.Log;

public class SoulEatingEnchantment implements IEnchantment {
    @Override
    public void onActivate() {
        Log.d("Bridge", "The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        Log.d("Bridge", "The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        Log.d("Bridge", "Bloodlust slowly disappears.");
    }
}
