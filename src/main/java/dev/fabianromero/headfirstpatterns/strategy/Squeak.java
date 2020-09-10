package dev.fabianromero.headfirstpatterns.strategy;

public class Squeak implements QuackBehavior {
    @Override
    public String performQuack() {
        return "I'm squeaking like a rubber duckie!";
    }
}
