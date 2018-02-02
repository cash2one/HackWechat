package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

public final class b {
    public static void a(boolean z, boolean z2, e eVar) {
        x.v("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        try {
            g.t(Boolean.valueOf(z), Boolean.valueOf(z2)).c(new a()).c(new c()).c(new d()).a(new 2(eVar)).a(new 1(System.currentTimeMillis(), eVar));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SoterInitManager", e, "alvinluo exception when init soter: %s", new Object[]{e.getMessage()});
            a.dM(4, 1001);
            if (eVar != null) {
                eVar.yc(-1);
            }
        }
    }
}
