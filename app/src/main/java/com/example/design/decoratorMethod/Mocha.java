package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

    public Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(2.0).add(beverage.cost());
    }
}
