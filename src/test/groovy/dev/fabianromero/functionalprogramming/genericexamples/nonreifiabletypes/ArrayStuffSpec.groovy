package dev.fabianromero.functionalprogramming.genericexamples.nonreifiabletypes

import groovy.transform.TypeChecked
import spock.lang.Specification

import java.time.LocalDate

@TypeChecked
class ArrayStuffSpec extends Specification {
    def "A List of generic type can be converted to an array of that type"() {
        given: "A List of a type and an ArrayStuff object"
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana")
        def arrayStuff = new ArrayStuff()

        when: "The result is gotten"
        //This compiles if we just receive the class as argument without validate variance, once the variance
        //is added, the compiler shows the error (it is necessary to add @TypeChecked in order to validate types
        //in Groovy)
        //String[] fruitsArray = arrayStuff.getAsArray(fruits, LocalDate.class)
        String[] fruitsArray = arrayStuff.getAsArray(fruits, String.class)

        then: "It must return the expected array"
        String[] fruitsExpected = ["Apple", "Orange", "Banana"]
        fruitsExpected == fruitsArray
    }
}