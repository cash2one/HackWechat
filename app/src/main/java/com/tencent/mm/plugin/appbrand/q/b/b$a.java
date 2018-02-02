package com.tencent.mm.plugin.appbrand.q.b;

public enum b$a {
    GPS,
    NETWORK;

    public static b$a uG(String str) {
        if ("gps".equals(str)) {
            return GPS;
        }
        return NETWORK;
    }
}
