package com.example.design.designCombat;

public interface StockUpdateQueue {

    void put(StockMessage message) throws InterruptedException;

    void putDirect(StockMessage message) throws InterruptedException;

    StockMessage take() throws InterruptedException;

    Integer size();

}
