package com.tencent.mm.plugin.r;

import com.tencent.mm.kernel.b.c;

public final class b implements c {
    private static b ooe;

    private b() {
    }

    public static synchronized b aZg() {
        b bVar;
        synchronized (b.class) {
            if (ooe == null) {
                ooe = new b();
            }
            bVar = ooe;
        }
        return bVar;
    }
}
