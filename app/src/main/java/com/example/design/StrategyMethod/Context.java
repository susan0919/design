package com.example.design.StrategyMethod;

public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void stragegyMethod() {
        strategy.StragtegyMethod();
    }
}
