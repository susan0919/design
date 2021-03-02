package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(7.9);
    }
}
