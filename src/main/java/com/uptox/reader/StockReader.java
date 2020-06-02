package com.uptox.reader;

import com.google.gson.*;
import com.uptox.StockQueue;
import com.uptox.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.time.ZonedDateTime;

public class StockReader implements IReader{
    private static final Logger logger = LoggerFactory.getLogger(StockReader.class);
    private final StockQueue queue;

    public StockReader(StockQueue queue) {
        this.queue = queue;
    }

    @Override
    public void read(String stockSymbol, URL path) {
        if(stockSymbol == null || stockSymbol.length() == 0 ) return;
        try(FileReader reader = new FileReader(new File(path.toURI()))) {
            Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer()).create();
            JsonStreamParser p = new JsonStreamParser(reader);
            while (p.hasNext()) {
                JsonElement e = p.next();
                if (e.isJsonObject()) {
                    Stock m = gson.fromJson(e, Stock.class);
                    if(stockSymbol.equalsIgnoreCase(m.getSym())) {
                        queue.add(m);
                        //logger.info(m.toString());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
