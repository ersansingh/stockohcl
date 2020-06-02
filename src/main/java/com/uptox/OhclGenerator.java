package com.uptox;

import com.uptox.processor.OhclProcessor;
import com.uptox.reader.StockReader;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OhclGenerator {

    public static void generate(URL path, String stockSymbol, long ohclBarIntervalInSec) {
        StockQueue queue = StockQueue.INSTANCE;
        StockReader stockReader = new StockReader(queue);
        OhclProcessor finiteStateMachine = new OhclProcessor(queue, ohclBarIntervalInSec);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> stockReader.read(stockSymbol, path));
        executorService.execute(() -> {
            try {
                finiteStateMachine.process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
