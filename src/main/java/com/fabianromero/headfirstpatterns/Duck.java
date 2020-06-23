package com.fabianromero.headfirstpatterns;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public String fly() {
        return flyBehavior.performFly();
    }

    public String quack() {
        return quackBehavior.performQuack();
    }

    public abstract void display();
}
