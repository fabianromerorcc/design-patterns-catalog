package com.fabianromero.headfirstpatterns;

public class FlyNoWay implements FlyBehavior {
    @Override
    public String performFly() {
        return "I can't fly!";
    }
}
