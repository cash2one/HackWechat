package com.tencent.mm.z.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    b$1() {
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        b.ID();
        if (i == 0 && i2 == 0) {
            xj xjVar = (xj) bVar.hmh.hmo;
            b.uc();
            b.hd(xjVar.waZ);
            b.hc(xjVar.wib);
            b.F(xjVar.wic);
            b.G(xjVar.wia);
            b.uj();
            x.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[]{Integer.valueOf(xjVar.wib)});
        } else {
            x.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400)});
            b.uc();
            b.hc(86400);
            b.uj();
        }
        return 0;
    }
}
