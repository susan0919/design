package com.example.design.decoratorMethod;

import java.math.BigDecimal;

public abstract class Beverage {
    String description = "unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal cost();
}
