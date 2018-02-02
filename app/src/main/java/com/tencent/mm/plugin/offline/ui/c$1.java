package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$1 extends c<sz> {
    final /* synthetic */ PayInfo oXJ;
    final /* synthetic */ c oXK;

    c$1(c cVar, PayInfo payInfo) {
        this.oXK = cVar;
        this.oXJ = payInfo;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        a.xef.c(this);
        if (szVar.fLs.result == 0) {
            k cVar = new com.tencent.mm.plugin.offline.a.c(this.oXJ.fuH, this.oXJ.fCV, this.oXJ.fCR);
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
            com.tencent.mm.plugin.offline.g.bgT();
            this.oXK.oXF.bhl();
        } else if (szVar.fLs.result == -1) {
            com.tencent.mm.plugin.offline.g.bgT();
            this.oXK.oXF.bhl();
        }
        return false;
    }
}
