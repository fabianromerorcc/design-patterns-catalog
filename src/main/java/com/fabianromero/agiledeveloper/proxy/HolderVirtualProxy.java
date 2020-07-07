package com.fabianromero.agiledeveloper.proxy;

public class HolderVirtualProxy {

    private Heavy heavy = new Heavy();

    public Heavy getHeavy() {
        return heavy;
    }
}
