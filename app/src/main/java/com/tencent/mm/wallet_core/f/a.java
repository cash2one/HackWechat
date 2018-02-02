package com.tencent.mm.wallet_core.f;

import java.util.WeakHashMap;

public final class a {
    public WeakHashMap<Object, Boolean> zIa = new WeakHashMap();

    public static synchronized a cBK() {
        a aVar;
        synchronized (a.class) {
            aVar = a.zIb;
        }
        return aVar;
    }
}
