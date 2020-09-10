package dev.fabianromero.headfirstpatterns.strategy;

public class FlyWithWings implements FlyBehavior {
    @Override
    public String performFly() {
        return "I'm flying with wings!";
    }
}
