package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.caq;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class w$2 implements a {
    w$2() {
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        g.pQN.a(368, 40, 1, false);
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xrF, Long.valueOf(86400 + bh.Wo()));
        }
        if (i == 0 && i2 == 0) {
            try {
                w.b(((caq) bVar.hmg.hmo).version, (car) bVar.hmh.hmo, w.a.iEV);
            } catch (RuntimeException e) {
                x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", new Object[]{e});
            }
        } else {
            x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        return 0;
    }
}
