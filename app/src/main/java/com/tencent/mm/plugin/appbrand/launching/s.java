package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

final class s {
    static void a(a aVar, String str, int i, int i2, int i3, long j) {
        int tX = a.tX(str);
        x.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %s", new Object[]{aVar.name(), str, Long.valueOf(j), Integer.valueOf(tX)});
        g.pQN.h(13886, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(aVar.iYZ), "", "", Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(tX)});
    }
}
