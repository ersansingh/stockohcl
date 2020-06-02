package com.uptox.processor;

import com.uptox.StockQueue;
import com.uptox.model.Ohcl;
import com.uptox.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;

public class OhclProcessor implements IProcessor{
    private static final Logger logger = LoggerFactory.getLogger(OhclProcessor.class);
    private final StockQueue queue;
    private long ohclBarIntervalInSec;

    public OhclProcessor(StockQueue queue, long ohclBarIntervalInSec) {
        this.queue = queue;
        this.ohclBarIntervalInSec = ohclBarIntervalInSec;
    }

    @Override
    public void process() throws InterruptedException {
        Duration timeElapsed = Duration.ZERO;
        Stock currentStock = queue.consume();
        Stock nextStock;

        Ohcl ohcl = Ohcl.builder()
                .event("ohlc_notify")
                .symbol(currentStock.getSym())
                .bar_num(1)
                .open(currentStock.getP())
                .high(currentStock.getP())
                .low(currentStock.getP())
                .volume(currentStock.getQ())
                .close(currentStock.getP()).build();

        while (Objects.nonNull(currentStock)) {
            nextStock = queue.consume();

            if(Objects.nonNull(nextStock)){
                timeElapsed = timeElapsed.plus(Duration.between(currentStock.getTS2(), nextStock.getTS2()));
                if (timeElapsed.getSeconds() > ohclBarIntervalInSec) ohcl = ohcl.toBuilder().close(currentStock.getP()).build();
            }

            logger.info(ohcl.toString());

            if(Objects.nonNull(nextStock)){
                Ohcl.OhclBuilder builder = ohcl.toBuilder()
                        .volume(ohcl.getVolume() + nextStock.getQ())
                        .close(0.0);
                if (timeElapsed.getSeconds() > ohclBarIntervalInSec) {
                    builder.bar_num(ohcl.getBar_num() + 1)
                            .open(nextStock.getP())
                            .high(nextStock.getP())
                            .low(nextStock.getP());
                    timeElapsed = Duration.ZERO;
                } else {
                    builder.high(ohcl.getHigh() > nextStock.getP() ? ohcl.getHigh() : nextStock.getP())
                            .low(ohcl.getLow() < nextStock.getP() ? ohcl.getLow() : nextStock.getP());
                }
                ohcl = builder.build();
            }

            currentStock = nextStock;
        }
    }
}
