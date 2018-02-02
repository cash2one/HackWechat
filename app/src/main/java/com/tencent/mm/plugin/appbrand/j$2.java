package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements a {
    final /* synthetic */ j irY;
    final /* synthetic */ String irZ;

    j$2(j jVar, String str) {
        this.irY = jVar;
        this.irZ = str;
    }

    public final void po(String str) {
        g.pQN.a(370, 31, 1, false);
    }

    public final void fq(String str) {
        x.e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", this.irZ, str);
        g.pQN.a(370, 32, 1, false);
    }
}
