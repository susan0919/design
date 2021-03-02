package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class DarkBeverage extends Beverage {

    public DarkBeverage() {
        description = "DarkRoast";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(3.3);
    }
}
