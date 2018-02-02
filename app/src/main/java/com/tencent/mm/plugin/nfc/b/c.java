package com.tencent.mm.plugin.nfc.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static void N(String str, int i, int i2) {
        x.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        g.pQN.h(14837, str, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
