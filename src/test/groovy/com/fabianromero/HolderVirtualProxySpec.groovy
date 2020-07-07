package com.fabianromero

import com.fabianromero.agiledeveloper.proxy.Heavy
import com.fabianromero.agiledeveloper.proxy.HolderVirtualProxy
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

    def "Virtual Proxy brings results as expected"() {
        given: "A Holder object and a Heavy retrieved from Holder"
        def proxy = new HolderVirtualProxy()
        def heavy = proxy.getHeavy()

        when: "Some method is called"
        def result = heavy.someMethod()

        then: "It must return expected String"
        result == "Executing someMethod..."
    }
}