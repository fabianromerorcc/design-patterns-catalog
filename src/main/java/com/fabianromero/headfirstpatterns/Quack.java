package com.fabianromero.headfirstpatterns;

public class Quack implements QuackBehavior {
    @Override
    public String performQuack() {
        return "I'm quacking like a duck!";
    }
}
