package dev.fabianromero


import dev.fabianromero.headfirstpatterns.strategy.Squeak
import dev.fabianromero.headfirstpatterns.strategy.DecoyDuck
import dev.fabianromero.headfirstpatterns.strategy.FlyBehavior
import dev.fabianromero.headfirstpatterns.strategy.FlyNoWay
import dev.fabianromero.headfirstpatterns.strategy.FlyWithWings
import dev.fabianromero.headfirstpatterns.strategy.MallardDuck
import dev.fabianromero.headfirstpatterns.strategy.MuteQuack
import dev.fabianromero.headfirstpatterns.strategy.Quack
import dev.fabianromero.headfirstpatterns.strategy.QuackBehavior
import dev.fabianromero.headfirstpatterns.strategy.RubberDuck
import spock.lang.Specification

class DuckSpec extends Specification {

    def "Given a Duck it is possible to add fly and quack capabilities"() {
        given: "A new Duck like a MallardDuck, a fly and quack behavior"
        FlyBehavior flyBehavior = new FlyWithWings()
        QuackBehavior quackBehavior = new Quack()
        def duck = new MallardDuck(flyBehavior, quackBehavior)

        when: "It performs quack and fly"
        def flyResponse = duck.fly()
        def quackResponse = duck.quack()

        then: "Has to perform like a MallardDuck"
        flyResponse == "I'm flying with wings!"
        quackResponse == "I'm quacking like a duck!"
    }

    def "Given a RubberDuck it is possible to add squeak and no-fly capabilities "() {
        given: "A new RubberDuck, squeak and no-fly behavior"
        def flyBehavior = new FlyNoWay()
        def quackBehavior = new Squeak()
        def duck = new RubberDuck(flyBehavior, quackBehavior)

        when: "It performs fly and quack"
        def flyResponse = duck.fly()
        def quackResponse = duck.quack()

        then: "Instead of quack, squeak and say that cannot fly"
        flyResponse == "I can't fly!"
        quackResponse == "I'm squeaking like a rubber duckie!"

    }

    def "Given a DecoyDuck it is possible to add no quacking and no-fly capabilities"() {
        given: "A new DecoyDuck, mute quack and no-fly behavior"
        def flyBehavior = new FlyNoWay()
        def quackBehavior = new MuteQuack()
        def duck = new DecoyDuck(flyBehavior, quackBehavior)

        when: "it performs fly and quack"
        def flyResponse = duck.fly()
        def quackResponse = duck.quack()

        then: "It can't quack nor fly"
        flyResponse == "I can't fly!"
        quackResponse == "I can't quack! I'm just a decoy"
    }

}