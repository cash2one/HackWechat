package com.tencent.mm.z;

import com.tencent.mm.by.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c heJ;

    c$1(c cVar) {
        this.heJ = cVar;
    }

    public final void Db() {
        g.Dk();
        if (g.Dh().Cy()) {
            m Tg = q.Tg();
            if (Tg != null) {
                x.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + Tg);
                long currentTimeMillis = System.currentTimeMillis();
                Tg.hSq.lE(true);
                x.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        }
    }

    public final void Dc() {
    }

    public final void Dd() {
    }
}
