package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ int jGr;
    final /* synthetic */ b jGs;

    b$1(b bVar, int i) {
        this.jGs = bVar;
        this.jGr = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i != 0 || i2 != 0 || bVar.hmh.hmo == null) {
            x.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo);
        } else if (((amw) bVar.hmh.hmo).wte.fts == 0 && 1 == this.jGr) {
            x.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", b.a(this.jGs), b.b(this.jGs));
            b.ajv().put(b.a(this.jGs), b.b(this.jGs));
        }
    }
}
