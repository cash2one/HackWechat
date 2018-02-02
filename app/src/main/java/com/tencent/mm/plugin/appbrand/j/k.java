package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private static AtomicInteger jBn = new AtomicInteger(1);
    public HashMap<String, j> jhY;

    private k() {
        this.jhY = new HashMap();
    }

    public static k aiE() {
        return a.aiF();
    }

    public final j tB(String str) {
        if (this.jhY.containsKey(str)) {
            return (j) this.jhY.get(str);
        }
        return null;
    }

    public static int aiw() {
        return jBn.incrementAndGet();
    }
}
