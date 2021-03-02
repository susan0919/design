package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {
    public Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",,Whip";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(3.8).add(beverage.cost());
    }
}
