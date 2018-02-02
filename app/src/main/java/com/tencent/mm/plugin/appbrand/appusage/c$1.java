package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c iIW;

    c$1(c cVar) {
        this.iIW = cVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0 && bVar != null && bVar.hmh.hmo != null && (bVar.hmh.hmo instanceof ait)) {
            c.a(this.iIW, (ait) bVar.hmh.hmo);
        } else {
            x.e("MicroMsg.AppBrandLauncherListWAGameLogic", "doRequest() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            c.a(this.iIW, null);
        }
        return 0;
    }
}
