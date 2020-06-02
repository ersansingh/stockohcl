package com.uptox.model;

import java.time.ZonedDateTime;

public class Stock {
    private String sym;
    private String T;
    private double P;
    private double Q;
    private String side;
    private ZonedDateTime TS2;

    Stock(String sym, String T, double P, double Q, String side, ZonedDateTime TS2) {
        this.sym = sym;
        this.T = T;
        this.P = P;
        this.Q = Q;
        this.side = side;
        this.TS2 = TS2;
    }

    public static StockBuilder builder() {
        return new StockBuilder();
    }

    public String getSym() {
        return this.sym;
    }

    public String getT() {
        return this.T;
    }

    public double getP() {
        return this.P;
    }

    public double getQ() {
        return this.Q;
    }

    public String getSide() {
        return this.side;
    }

    public ZonedDateTime getTS2() {
        return this.TS2;
    }

    public String toString() {
        return "Stock(sym=" + this.getSym() + ", T=" + this.getT() + ", P=" + this.getP() + ", Q=" + this.getQ() + ", side=" + this.getSide() + ", TS2=" + this.getTS2() + ")";
    }

    public StockBuilder toBuilder() {
        return new StockBuilder().sym(this.sym).T(this.T).P(this.P).Q(this.Q).side(this.side).TS2(this.TS2);
    }

    public static class StockBuilder {
        private String sym;
        private String T;
        private double P;
        private double Q;
        private String side;
        private ZonedDateTime TS2;

        StockBuilder() {
        }

        public Stock.StockBuilder sym(String sym) {
            this.sym = sym;
            return this;
        }

        public Stock.StockBuilder T(String T) {
            this.T = T;
            return this;
        }

        public Stock.StockBuilder P(double P) {
            this.P = P;
            return this;
        }

        public Stock.StockBuilder Q(double Q) {
            this.Q = Q;
            return this;
        }

        public Stock.StockBuilder side(String side) {
            this.side = side;
            return this;
        }

        public Stock.StockBuilder TS2(ZonedDateTime TS2) {
            this.TS2 = TS2;
            return this;
        }

        public Stock build() {
            return new Stock(sym, T, P, Q, side, TS2);
        }

        public String toString() {
            return "Stock.StockBuilder(sym=" + this.sym + ", T=" + this.T + ", P=" + this.P + ", Q=" + this.Q + ", side=" + this.side + ", TS2=" + this.TS2 + ")";
        }
    }
}
