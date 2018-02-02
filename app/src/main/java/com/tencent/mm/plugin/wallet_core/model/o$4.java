package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.a.nk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class o$4 extends c<nk> {
    final /* synthetic */ o sPi;

    o$4(o oVar) {
        this.sPi = oVar;
        this.xen = nk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nk nkVar = (nk) bVar;
        o.t(nkVar.fFu.context, nkVar.fFu.intent);
        return true;
    }
}
