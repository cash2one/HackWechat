package com.tencent.mm.ui.chatting;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class z$2 implements Runnable {
    final /* synthetic */ z yxf;

    z$2(z zVar) {
        this.yxf = zVar;
    }

    public final void run() {
        if (ar.Hj()) {
            ar.CG().a(new m(37), 0);
            ar.Hg();
            c.CU().set(68108, Long.valueOf(t.Wo()));
        }
    }
}
