package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.sg;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class f$11 extends c<sg> {
    final /* synthetic */ f iDI;

    f$11(f fVar) {
        this.iDI = fVar;
        this.xen = sg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        sg sgVar = (sg) bVar;
        if (!bh.ov(sgVar.fJX.fnl)) {
            q.abY();
            String str = sgVar.fJX.fnl;
            int i = sgVar.fJX.fJZ;
            if (sgVar.fJX.action != 1) {
                z = false;
            }
            sgVar.fJY.fKa = q.i(str, i, z);
        }
        return false;
    }
}
