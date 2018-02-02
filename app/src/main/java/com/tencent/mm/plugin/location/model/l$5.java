package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.bj;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class l$5 extends c<bj> {
    final /* synthetic */ l nRF;

    l$5(l lVar) {
        this.nRF = lVar;
        this.xen = bj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a aVt = l.aVt();
        x.i("MicroMsg.StaticMapMsgLogic", "clean task");
        aVt.nQY.clear();
        aVt.nRc.clear();
        aVt.nRd.clear();
        aVt.nRa.clear();
        aVt.nRb.clear();
        aVt.nRe.clear();
        aVt.nQZ.clear();
        l.aVs().a(aVt);
        l.aVs().a(aVt);
        return false;
    }
}
