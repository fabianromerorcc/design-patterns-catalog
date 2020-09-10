package dev.fabianromero


import dev.fabianromero.headfirstpatterns.decorator.Beverage
import dev.fabianromero.headfirstpatterns.decorator.DarkRoast
import dev.fabianromero.headfirstpatterns.decorator.HouseBlend
import dev.fabianromero.headfirstpatterns.decorator.Milk
import dev.fabianromero.headfirstpatterns.decorator.Mocha
import dev.fabianromero.headfirstpatterns.decorator.Soy
import dev.fabianromero.headfirstpatterns.decorator.Whip
import spock.lang.Specification


class BeverageSpec extends Specification {

    def "Given a Beverage of type HouseBlend it is possible to add condiments in a flexible way"() {
        given: "A Beverage of type HouseBlend and one condiment, Milk"
        Beverage coffee = new HouseBlend()
        def beverageWithCondiments = new Milk(coffee)

        when: "It tries to calculate cost of the Beverage and get full description of product"
        def cost = beverageWithCondiments.cost()
        def description = beverageWithCondiments.getDescription()

        then: "It must add Beverage base cost plus condiments cost and show a full description of product"
        cost == 1700
        description == "House Blend Coffee, Milk"
    }

    def "A cost and description is computed for base coffee plus two condiments"() {
        given: "A base coffee and two condiments"
        def coffee = new HouseBlend()
        Beverage beverageWithCondiments = new Milk(new Mocha(coffee))

        when:
        def cost = beverageWithCondiments.cost()
        def description = beverageWithCondiments.getDescription()

        then:
        cost == 2200
        description == "House Blend Coffee, Mocha, Milk"
        println cost + description
    }

    def "A cost and description is computed with Dark Roast base and Soy and Whip condiments"() {
        given: "Dark Roast coffee as a base and Soy and Whip as condiments"
        def coffee = new DarkRoast()
        Beverage beverageWithCondiments = new Soy(new Whip(coffee))

        when:
        def cost = beverageWithCondiments.cost()
        def description = beverageWithCondiments.getDescription()

        then:
        cost == 2100
        description == "Dark Roast Coffee, Whip, Soy"

    }

}