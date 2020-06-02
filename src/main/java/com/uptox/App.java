package com.uptox;

import java.net.URL;

public class App {
    public static void main(String[] args) {
        URL path = ClassLoader.getSystemResource("trades.json");
        String stockSymbol = System.getProperty("stockSymbol").trim();
        long barIntervalInSec = Long.valueOf(System.getProperty("barIntervalInSec").trim());

        OhclGenerator.generate(path, stockSymbol, barIntervalInSec);
    }
}
