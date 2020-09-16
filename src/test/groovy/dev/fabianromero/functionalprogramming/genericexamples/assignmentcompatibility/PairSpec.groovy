package dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility

import dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility.ClothingPair
import dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility.Pair
import dev.fabianromero.functionalprogramming.genericexamples.assignmentcompatibility.Shoe
import spock.lang.Specification


class PairSpec extends Specification {

    def "A Pair must hold any type of pair objects"() {
        given: "An object that live in pairs, like a shoe"
        def leftShoe = new Shoe(42)
        def rightShoe = new Shoe(42)

        when: "Is it created and assigned"
        Pair<Shoe> pair = new ClothingPair(leftShoe, rightShoe)

        then: "It must be supported and have the same class contained"
        pair.getRight().class == Shoe.class
        pair.getLeft().class == Shoe.class
    }

    def "A Pair must make sure that pair elements have the same characteristics"() {
        given: "An object that live in pairs, like a shoe"
        def leftShoe = new Shoe(size: 42)
        def rightShoe = new Shoe(size: 41)

        when: "Is it assigned"
        Pair<Shoe> pair = new ClothingPair<>(leftShoe, rightShoe)

        then: "Must throw an exception if elements don't have the same characteristics "
        thrown(IllegalStateException)
    }

    def "A Pair must validate that elements have the same color in a ClothingPair"() {
        given: "A ClothingPair"
        def leftShoe = new Shoe(size: 42, color: "red")
        def rightShoe = new Shoe(size: 42, color: "blue")

        when: "A ClothingPair is created with elements with unmatched colors"
        Pair<Shoe> pair = new ClothingPair<>(leftShoe, rightShoe)

        then: "It must throw an IllegalStateException"
        thrown(IllegalStateException)
    }
}