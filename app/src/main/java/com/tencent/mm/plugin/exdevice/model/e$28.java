package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ed;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$28 extends c<ed> {
    final /* synthetic */ e lLO;

    e$28(e eVar) {
        this.lLO = eVar;
        this.xen = ed.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ed edVar = (ed) bVar;
        if (ad.aEk().aEP().size() > 0) {
            edVar.fsN.frp = true;
        } else {
            edVar.fsN.frp = false;
        }
        return true;
    }
}
