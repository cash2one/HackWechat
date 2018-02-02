package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class f$16 extends c<p> {
    final /* synthetic */ f iDI;

    f$16(f fVar) {
        this.iDI = fVar;
        this.xen = p.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        p pVar = (p) bVar;
        if (!bh.ov(pVar.fnw.fnl)) {
            String str = pVar.fnw.fnl;
            f.Zl().aV(str + "_unreadCount", pVar.fnw.fnm);
            d.ay(q.qQ(str), pVar.fnw.fnm);
        }
        return false;
    }
}
