package com.tencent.mm.ag;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements a$a {
    final /* synthetic */ k hpT;
    long lastReportTime = 0;

    k$2(k kVar) {
        this.hpT = kVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        x.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        if (bh.Wo() >= this.lastReportTime + ((long) this.hpT.hpQ)) {
            k.a(this.hpT.userName, 11, f2, f, (int) d2, null);
            this.lastReportTime = bh.Wo();
        }
        if (this.hpT.hpN == 2) {
            this.hpT.LY();
        }
        if (!this.hpT.hpR) {
            this.hpT.hpR = true;
            o.a(2013, f, f2, (int) d2);
        }
        return true;
    }
}
