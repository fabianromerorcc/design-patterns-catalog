package com.fabianromero.headfirstpatterns;

public class MuteQuack implements QuackBehavior {
    @Override
    public String performQuack() {
        return "I can't quack! I'm just a decoy";
    }
}
