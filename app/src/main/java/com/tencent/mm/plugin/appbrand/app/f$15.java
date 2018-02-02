package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class f$15 extends c<m> {
    final /* synthetic */ f iDI;

    f$15(f fVar) {
        this.iDI = fVar;
        this.xen = m.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        m mVar = (m) bVar;
        if (!bh.ov(mVar.fnj.fnl)) {
            mVar.fnk.fnm = bh.getInt(f.Zl().get(mVar.fnj.fnl + "_unreadCount", "0"), 0);
        }
        return false;
    }
}
