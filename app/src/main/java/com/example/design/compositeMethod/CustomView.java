package com.example.design.compositeMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomView {
    protected List<CustomView> views = new ArrayList<>();
    protected String name;

    public CustomView(String name) {
        this.name = name;
    }


    public abstract void printView(String placeHolder);
}
