package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b jGs;

    b$2(b bVar) {
        this.jGs = bVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            b.a(this.jGs, (amu) bVar.hmh.hmo);
            return;
        }
        x.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo);
        b.ajv().E(b.a(this.jGs), b.b(this.jGs));
        b.c(this.jGs).ajy();
    }
}
