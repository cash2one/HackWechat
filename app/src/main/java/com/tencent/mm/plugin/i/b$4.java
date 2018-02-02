package com.tencent.mm.plugin.i;

import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.i.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;

class b$4 implements Runnable {
    final /* synthetic */ b kHR;
    final /* synthetic */ boolean kHU;

    b$4(b bVar, boolean z) {
        this.kHR = bVar;
        this.kHU = z;
    }

    public final void run() {
        if (this.kHU) {
            b.a(this.kHR, true);
        }
        if (b.a(this.kHR) && b.b(this.kHR) == null) {
            b jiVar = new ji();
            if (this.kHR.asJ()) {
                b.a(this.kHR, false);
                jiVar.fzK.fdb = true;
                a.xef.m(jiVar);
                g.pQN.a(664, 9, 1, false);
                return;
            }
            if (this.kHU) {
                g.pQN.a(664, 7, 1, false);
            }
            jiVar.fzK.fzL = b.asL();
            jiVar.fzK.fzM = b.asI();
            jiVar.fzK.fdb = false;
            a.xef.m(jiVar);
            b.a(this.kHR, new c("message", b.asL(), b.asM(), b.c(this.kHR)));
            b.d(this.kHR).F(b.b(this.kHR));
            if (((Long) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwn, Long.valueOf(0))).longValue() <= 0) {
                com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwn, Long.valueOf(bh.Wo()));
            }
        }
    }
}
