package dev.fabianromero.functionalprogramming.genericexamples.variance

import groovy.transform.TypeChecked
import spock.lang.Specification


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

    @TypeChecked
    def "Preparing buld taxes giving a List of subtypes Taxable must be accepted"() {
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

}