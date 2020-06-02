package com.uptox;

import com.uptox.model.Stock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class StockQueue {
    private BlockingQueue<Stock> queue = new ArrayBlockingQueue<Stock>(100000);
    public static final StockQueue INSTANCE = new StockQueue();

    private StockQueue(){
        if(INSTANCE != null) throw new IllegalAccessError("Cannot Instantiate StockQueue twice");
    }

    public boolean add(Stock stock){
        return queue.offer(stock);
    }

    public Stock consume() throws InterruptedException{
        return queue.poll(10, TimeUnit.SECONDS);
    }
}
