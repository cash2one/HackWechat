package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class t$4 implements a {
    final /* synthetic */ t jFj;

    t$4(t tVar) {
        this.jFj = tVar;
    }

    public final void po(String str) {
        g.pQN.a(370, 3, 1, false);
    }

    public final void fq(String str) {
        int i = 0;
        x.e("MicroMsg.AppBrandWebView", "Inject SDK Page Script Failed: %s", new Object[]{str});
        g.pQN.a(370, 2, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.z(t.a(this.jFj), 24, 0);
        int i2 = -1;
        if (t.b(this.jFj) != null) {
            i = t.b(this.jFj).iqx.iOI.iGL;
            i2 = t.b(this.jFj).iqx.iOI.iGK;
        }
        com.tencent.mm.plugin.appbrand.report.a.a(t.a(this.jFj), i, i2, 370, 2);
    }
}
