package com.example.design.compositeMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class View {
    protected List<View> views = new ArrayList<>();
    protected String name;

    public View(String name) {
        this.name = name;
    }


    public abstract void printView(String placeHolder);
}
