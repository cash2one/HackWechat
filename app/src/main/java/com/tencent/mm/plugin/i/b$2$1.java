package com.tencent.mm.plugin.i;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.b.2;
import com.tencent.mm.plugin.i.c.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class b$2$1 implements Runnable {
    final /* synthetic */ 2 kHS;

    b$2$1(2 2) {
        this.kHS = 2;
    }

    public final void run() {
        x.i("MicroMsg.CalcWxService", "start to calc");
        if (this.kHS.kHR.asJ()) {
            b bVar = this.kHS.kHR;
            if (bh.bz(((Long) g.Dj().CU().get(a.xwm, Long.valueOf(0))).longValue()) >= 259200000) {
                if (bVar.kHJ != null) {
                    bVar.kHJ.isStop = true;
                }
                bVar.kHJ = new b();
                bVar.i(bVar.kHJ);
                g.Dj().CU().a(a.xwm, Long.valueOf(bh.Wp()));
                return;
            }
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(664, 1, 1, false);
        b.i(this.kHS.kHR);
    }
}
