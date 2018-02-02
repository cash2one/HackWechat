package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class c$1 implements a {
    final /* synthetic */ long lkU;
    final /* synthetic */ c lnv;

    c$1(c cVar, long j) {
        this.lnv = cVar;
        this.lkU = j;
    }

    public final void v(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
            b.I(str, 3);
            n.JS().iY(str);
        } else {
            x.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(c.a(this.lnv), c.b(this.lnv));
    }
}
