package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(5.7);
    }
}
