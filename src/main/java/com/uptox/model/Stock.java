package com.uptox.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter @ToString
@Builder(toBuilder = true)
public class Stock {
    private String sym;
    private String T;
    private double P;
    private double Q;
    private String side;
    private ZonedDateTime TS2;
}
