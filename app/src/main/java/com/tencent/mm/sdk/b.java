package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.az;

public class b<T> extends az<T> {
    private final Object mLock = new Object();

    public b() {
        super(20);
    }

    public final T bG() {
        T bG;
        synchronized (this.mLock) {
            bG = super.bG();
        }
        return bG;
    }

    public final boolean j(T t) {
        boolean j;
        synchronized (this.mLock) {
            j = super.j(t);
        }
        return j;
    }
}
