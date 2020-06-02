package com.uptox.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(toBuilder = true)
@ToString @Getter
public class Ohcl {
    private String event;
    private String symbol;
    private int bar_num;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
}
