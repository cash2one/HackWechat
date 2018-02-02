package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ b jgq;

    b$1(b bVar, p pVar, int i) {
        this.jgq = bVar;
        this.jdJ = pVar;
        this.gOK = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
            this.jdJ.E(this.gOK, this.jgq.e("ok", null));
            return;
        }
        x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        this.jdJ.E(this.gOK, this.jgq.e("fail:cgi fail", null));
    }
}
