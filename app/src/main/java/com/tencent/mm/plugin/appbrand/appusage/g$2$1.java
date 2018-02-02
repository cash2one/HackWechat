package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.appusage.g.2;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.sdk.platformtools.x;

class g$2$1 implements a {
    final /* synthetic */ 2 iJq;

    g$2$1(2 2) {
        this.iJq = 2;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0 && bVar != null && bVar.hmh.hmo != null && (bVar.hmh.hmo instanceof aip)) {
            g.a((aip) bVar.hmh.hmo);
        } else {
            x.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.a(null);
        }
        return 0;
    }
}
