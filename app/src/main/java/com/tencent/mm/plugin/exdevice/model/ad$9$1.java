package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.model.ad.9;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ad$9$1 implements Runnable {
    final /* synthetic */ Object kpI;
    final /* synthetic */ 9 lNZ;

    ad$9$1(9 9, Object obj) {
        this.lNZ = 9;
        this.kpI = obj;
    }

    public final void run() {
        String str = (String) this.kpI;
        if (ad.aEm().za(str)) {
            ar.Hg();
            if (!c.EY().WK(str)) {
                ar.CG().a(new h(str, null), 0);
            }
        }
    }
}
