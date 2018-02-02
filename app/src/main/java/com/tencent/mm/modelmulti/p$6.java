package com.tencent.mm.modelmulti;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class p$6 implements Runnable {
    final /* synthetic */ p hGP;
    final /* synthetic */ long hGW;
    final /* synthetic */ a hGX;
    final /* synthetic */ long hGY;

    p$6(p pVar, long j, a aVar, long j2) {
        this.hGP = pVar;
        this.hGW = j;
        this.hGX = aVar;
        this.hGY = j2;
    }

    public final void run() {
        ar.Hg();
        c.CU().a(a.xtT, Long.valueOf(this.hGW));
        if (this.hGX != null) {
            ar.Hg();
            c.CU().a(this.hGX, Long.valueOf(this.hGY));
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[]{Long.valueOf(this.hGW), Long.valueOf(p.r(this.hGP)), this.hGX, Long.valueOf(this.hGY)});
    }
}
