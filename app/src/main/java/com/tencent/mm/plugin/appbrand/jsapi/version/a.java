package com.tencent.mm.plugin.appbrand.jsapi.version;

public enum a {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String jrO;

    private a(String str) {
        this.jrO = str;
    }

    public static a sN(String str) {
        for (a aVar : values()) {
            if (aVar.jrO.equals(str)) {
                return aVar;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid name %s", new Object[]{str}));
    }

    public final String toString() {
        return this.jrO;
    }
}
