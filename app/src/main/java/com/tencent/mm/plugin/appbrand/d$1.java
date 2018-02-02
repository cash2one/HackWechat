package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.g.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;

class d$1 extends c<e> {
    d$1() {
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((e) bVar).fmQ.fmR && g.Dh().Cy()) {
            long longValue = ((Long) g.Dj().CU().get(a.xrI, Long.valueOf(0))).longValue();
            long Wo = bh.Wo();
            if (Wo >= longValue) {
                d.ub();
                g.Dj().CU().a(a.xrI, Long.valueOf(Wo + 86400));
            }
        }
        return false;
    }
}
