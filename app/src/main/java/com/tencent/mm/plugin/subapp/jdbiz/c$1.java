package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.g.a.hm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$1 extends c<hm> {
    final /* synthetic */ c rWa;

    c$1(c cVar) {
        this.rWa = cVar;
        this.xen = hm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hm hmVar = (hm) bVar;
        if (hmVar != null && (hmVar instanceof hm)) {
            hmVar.fxP.url = this.rWa.bDX();
        }
        return false;
    }
}
