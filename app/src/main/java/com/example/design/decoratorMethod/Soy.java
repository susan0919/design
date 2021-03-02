package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {
    public Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(3.0).add(beverage.cost());
    }
}
