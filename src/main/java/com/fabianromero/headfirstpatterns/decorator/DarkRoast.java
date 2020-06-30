package com.fabianromero.headfirstpatterns.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 1300;
    }
}