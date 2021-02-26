package com.example.design.bridgeMethod;

import android.util.Log;

public class Hammer implements IWeapon {

    private final IEnchantment enchantment;

    public Hammer(IEnchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        Log.d("Bridge", "Hammer is wield");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        Log.d("Bridge", "Hammer is swing");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        Log.d("Bridge", "Hammer is unwield");
        enchantment.onDeactivate();
    }

    @Override
    public IEnchantment getIEnchantment() {
        return enchantment;
    }
}
