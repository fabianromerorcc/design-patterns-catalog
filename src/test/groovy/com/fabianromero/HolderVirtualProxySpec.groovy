package com.fabianromero

import spock.lang.Specification


class HolderVirtualProxySpec extends Specification {

    def "A Holder object must contain a Heavy object and do lazy initialization"() {
        given: "A Holder object that lazy initializes Heavy object"
        def holder = new HolderVirtualProxy()

        when: "A Heavy object is gotten"
        def heavy = holder.getHeavy()

        then: "Virtual Proxy Heavy must have a HeavyImpl uninitialized"
        heavy._heavy == null
    }
}