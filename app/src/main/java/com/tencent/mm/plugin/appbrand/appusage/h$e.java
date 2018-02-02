package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;

public final class h$e {
    public static final h$e iJI = new h$e();

    static int aba() {
        if (g.Dj().CU().getBoolean(a.xrW, false)) {
            return 1;
        }
        int intValue = ((Integer) g.Dj().CU().get(a.xrT, Integer.valueOf(0))).intValue();
        if (intValue > 0) {
            return intValue + 1;
        }
        return intValue;
    }

    static void a(String str, long j, int i, int i2) {
        com.tencent.mm.plugin.report.service.g.pQN.h(14112, new Object[]{Integer.valueOf(1), bh.ou(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
