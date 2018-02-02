package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class m {
    public static void run() {
        int i = g.zY().getInt("EnableFlockMultiProcSPProb", 0);
        ar.Hg();
        int aJ = h.aJ(c.Cg(), 101);
        boolean z = b.ceK() || (i > 0 && aJ >= 0 && aJ <= i);
        a.setValue(a.xgw, z);
        x.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[]{Integer.valueOf(aJ), Integer.valueOf(i), Boolean.valueOf(z)});
    }
}
