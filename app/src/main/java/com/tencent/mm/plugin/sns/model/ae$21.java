package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ae$21 extends c<nd> {
    final /* synthetic */ ae qWL;

    ae$21(ae aeVar) {
        this.qWL = aeVar;
        this.xen = nd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsAdClick snsAdClick = ((nd) bVar).fFd.fFe;
        k cVar = new com.tencent.mm.plugin.sns.a.b.c(snsAdClick.hOt, snsAdClick.hOx, snsAdClick.scene, "", snsAdClick.hOz, snsAdClick.hOu);
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
        return false;
    }
}
