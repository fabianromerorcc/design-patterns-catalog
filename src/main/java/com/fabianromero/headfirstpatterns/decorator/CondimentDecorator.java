package com.fabianromero.headfirstpatterns.decorator;

public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;
    public abstract String getDescription();
}
