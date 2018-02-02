package com.tencent.mm.booter;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    k$1() {
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            x.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
            k.L(f2);
            k.M(f);
            k.aT(true);
            if (k.wO() != null) {
                k.wO().c(k.wP());
                k.aT(false);
            }
        } else {
            x.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
        return false;
    }
}
