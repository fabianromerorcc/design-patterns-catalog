package com.fabianromero.agiledeveloper.proxy;

public class Heavy {
    private HeavyImpl _heavy = null;

    public String someMethod() {
        return getHeavy().someMethod();
    }

    private HeavyImpl getHeavy() {
        if (_heavy == null)
            _heavy = new HeavyImpl();
        return _heavy;
    }
}
