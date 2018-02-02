package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class d$1 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ d lvF;

    d$1(d dVar, String str) {
        this.lvF = dVar;
        this.icE = str;
    }

    public final void run() {
        this.lvF.ya(this.icE);
        if (this.lvF.lvD) {
            ar.Hg();
            c.CU().a(a.xns, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
