package com.example.design.bridgeMethod;

import android.util.Log;

public class Sword implements IWeapon {
    public IEnchantment enchantment;

    public Sword(IEnchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        Log.d("Bridge", "Sword is wield");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        Log.d("Bridge", "Sword is swing");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        Log.d("Bridge", "Sword si unwield");
        enchantment.onDeactivate();
    }

    @Override
    public IEnchantment getIEnchantment() {
        return enchantment;
    }
}
