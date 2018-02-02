package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.lb;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class ae$30 extends c<lb> {
    final /* synthetic */ ae qWL;

    ae$30(ae aeVar) {
        this.qWL = aeVar;
        this.xen = lb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lb lbVar = (lb) bVar;
        lbVar.fCo.fCs = lbVar.fCn.cOY == 1 ? i.bxQ().l(lbVar.fCn.fCp, lbVar.fCn.fqf, lbVar.fCn.fCq, lbVar.fCn.fCr) : i.bxQ().h(bh.VJ(lbVar.fCn.fCp), lbVar.fCn.fCq, lbVar.fCn.fCr);
        return false;
    }
}
