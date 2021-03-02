package com.example.design.designCombat;

import java.util.concurrent.ArrayBlockingQueue;

public class StockUpdateQueueImpl implements StockUpdateQueue {

    private static final Integer QUEUE_MAX_SIZE = 1000;
    private ArrayBlockingQueue<StockMessage> queue =
            new ArrayBlockingQueue<StockMessage>(QUEUE_MAX_SIZE);

    @Override
    public void put(StockMessage message) throws InterruptedException {
        queue.put(message);
    }

    @Override
    public void putDirect(StockMessage message) throws InterruptedException {
        queue.put(message);
    }

    @Override
    public StockMessage take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public Integer size() {
        return queue.size();
    }
}
