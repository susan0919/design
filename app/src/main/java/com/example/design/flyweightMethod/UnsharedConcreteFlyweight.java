package com.example.design.flyweightMethod;

public class UnsharedConcreteFlyweight {

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }
}
