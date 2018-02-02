package com.tencent.mm.plugin.appbrand.p;

import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.bh;

public final class i {
    public static <T extends a> boolean a(T t, T t2) {
        boolean z = false;
        if (t == null && t2 == null) {
            throw new IllegalArgumentException("both null!!!");
        }
        if (!(t == null || t2 == null)) {
            try {
                z = bh.isEqual(t.toByteArray(), t2.toByteArray());
            } catch (Exception e) {
            }
        }
        return z;
    }
}
