package com.tencent.mm.plugin.appbrand.p;

public final class k {
    public static String bi(Object obj) {
        return "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : "null");
    }

    public static String bG(long j) {
        return "Token@" + j;
    }
}
