package dev.fabianromero.headfirstpatterns.strategy;

public class DecoyDuck extends Duck {

    public DecoyDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {

    }
}
