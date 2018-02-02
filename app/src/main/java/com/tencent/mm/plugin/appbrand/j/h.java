package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private static AtomicInteger jBn = new AtomicInteger(1);
    public HashMap<String, f> jhY;

    private static class a {
        private static h jBO = new h();
    }

    private h() {
        this.jhY = new HashMap();
    }

    public static int aiw() {
        return jBn.incrementAndGet();
    }

    public static h aiC() {
        return a.jBO;
    }

    public final f tv(String str) {
        if (this.jhY.containsKey(str)) {
            return (f) this.jhY.get(str);
        }
        return null;
    }
}
