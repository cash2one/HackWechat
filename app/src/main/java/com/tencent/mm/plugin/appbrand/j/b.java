package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static AtomicInteger jBn = new AtomicInteger(1);
    public HashMap<String, a> jhY;

    private b() {
        this.jhY = new HashMap();
    }

    public static int aiw() {
        return jBn.incrementAndGet();
    }

    public static b aix() {
        return a.aiy();
    }

    public final a tq(String str) {
        if (this.jhY.containsKey(str)) {
            return (a) this.jhY.get(str);
        }
        return null;
    }
}
