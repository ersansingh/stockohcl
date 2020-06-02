package com.uptox.model;

public class Ohcl {
    private String event;
    private String symbol;
    private int bar_num;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;

    Ohcl(String event, String symbol, int bar_num, double open, double high, double low, double close, double volume) {
        this.event = event;
        this.symbol = symbol;
        this.bar_num = bar_num;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public static OhclBuilder builder() {
        return new OhclBuilder();
    }

    public String getEvent() {
        return this.event;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getBar_num() {
        return this.bar_num;
    }

    public double getOpen() {
        return this.open;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public double getClose() {
        return this.close;
    }

    public double getVolume() {
        return this.volume;
    }

    public String toString() {
        return "Ohcl(event=" + this.getEvent() + ", symbol=" + this.getSymbol() + ", bar_num=" + this.getBar_num() + ", open=" + this.getOpen() + ", high=" + this.getHigh() + ", low=" + this.getLow() + ", close=" + this.getClose() + ", volume=" + this.getVolume() + ")";
    }

    public OhclBuilder toBuilder() {
        return new OhclBuilder().event(this.event).symbol(this.symbol).bar_num(this.bar_num).open(this.open).high(this.high).low(this.low).close(this.close).volume(this.volume);
    }

    public static class OhclBuilder {
        private String event;
        private String symbol;
        private int bar_num;
        private double open;
        private double high;
        private double low;
        private double close;
        private double volume;

        OhclBuilder() {
        }

        public Ohcl.OhclBuilder event(String event) {
            this.event = event;
            return this;
        }

        public Ohcl.OhclBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Ohcl.OhclBuilder bar_num(int bar_num) {
            this.bar_num = bar_num;
            return this;
        }

        public Ohcl.OhclBuilder open(double open) {
            this.open = open;
            return this;
        }

        public Ohcl.OhclBuilder high(double high) {
            this.high = high;
            return this;
        }

        public Ohcl.OhclBuilder low(double low) {
            this.low = low;
            return this;
        }

        public Ohcl.OhclBuilder close(double close) {
            this.close = close;
            return this;
        }

        public Ohcl.OhclBuilder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public Ohcl build() {
            return new Ohcl(event, symbol, bar_num, open, high, low, close, volume);
        }

        public String toString() {
            return "Ohcl.OhclBuilder(event=" + this.event + ", symbol=" + this.symbol + ", bar_num=" + this.bar_num + ", open=" + this.open + ", high=" + this.high + ", low=" + this.low + ", close=" + this.close + ", volume=" + this.volume + ")";
        }
    }
}
