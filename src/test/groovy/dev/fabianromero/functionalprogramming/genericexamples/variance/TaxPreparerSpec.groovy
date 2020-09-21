package dev.fabianromero.functionalprogramming.genericexamples.variance

import groovy.transform.TypeChecked
import spock.lang.Specification

import java.lang.reflect.Array


class TaxPreparerSpec extends Specification {

    @TypeChecked
    def "Preparing bulk taxes must accept lists of Taxable items"() {
        given: "A list of Taxable items"
        List<Taxable> clients = new ArrayList<>()
        clients.add(new Individual())
        clients.add(new Corporation())


        def preparer = new TaxPreparer()

        when: "Prepare bulk taxes is invoked"

        def isOk = preparer.prepareBulkTaxes(clients)

        then: "The types must be accepted and execute the function"
        isOk
    }

    /*
    This annotation is to force type checking in calling prepareBulkTaxes and to validate the correct use of
    generics covariance
     */
    @TypeChecked
    def "Preparing bulk taxes giving a List of subtypes Taxable must be accepted"() {
        given: "A list of implementation of Taxable"
        List<Individual> clients = new ArrayList<>()
        clients.add(new Individual())
        clients.add(new Individual())
        TaxPreparer preparer = new TaxPreparer()

        when: "Prepare bulk taxes is invoked"
        def isOK = preparer.prepareBulkTaxes(clients)

        then: "The subtype must be accepted and complete the operation"
        isOK
    }

    @TypeChecked
    def "In a method that receives List<Individual>, List<Taxable> must be accepted "() {
        given: "A List of Taxable elements"
        List<Taxable> clients = new ArrayList<>()
        clients.add(new Corporation())
        def preparer = new TaxPreparer()

        when: "getIndividualClients is invoked"
        List<Taxable> clientsWithIndividuals = preparer.getIndividualClients(clients) as List<Taxable>
        def lastElement = clientsWithIndividuals.last()

        then: "The supertype must be accepted and complete the operation"
        //TODO I tried to do the clientsWithIndividuals.last() here but didn't compile and I don't know why
        lastElement.class == Individual.class
    }
}