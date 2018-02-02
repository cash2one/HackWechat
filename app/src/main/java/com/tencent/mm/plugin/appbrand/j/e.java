package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static AtomicInteger jBn = new AtomicInteger(1);
    public HashMap<String, c> jhY;

    private e() {
        this.jhY = new HashMap();
    }

    public static int aiw() {
        return jBn.incrementAndGet();
    }

    public static e aiA() {
        return a.aiB();
    }

    public final c tt(String str) {
        if (this.jhY.containsKey(str)) {
            return (c) this.jhY.get(str);
        }
        return null;
    }
}
