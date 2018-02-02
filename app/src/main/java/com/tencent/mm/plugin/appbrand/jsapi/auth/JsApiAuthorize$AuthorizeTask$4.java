package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.a.a;

class JsApiAuthorize$AuthorizeTask$4 implements a<com.tencent.mm.u.a.a> {
    final /* synthetic */ AuthorizeTask jgb;
    final /* synthetic */ AuthorizeTask.a jgd;

    JsApiAuthorize$AuthorizeTask$4(AuthorizeTask authorizeTask, AuthorizeTask.a aVar) {
        this.jgb = authorizeTask;
        this.jgd = aVar;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        com.tencent.mm.u.a.a aVar = (com.tencent.mm.u.a.a) kVar;
        x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jgd.afG();
        } else if (aVar instanceof com.tencent.mm.u.a.a) {
            amj BV = aVar.BV();
            int i3 = BV.wte.fts;
            String str2 = BV.wte.ftt;
            x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                this.jgd.a(BV.whQ, BV.niZ, BV.vFW);
            } else if (i3 == 0) {
                this.jgd.onSuccess();
            } else {
                x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                this.jgd.afG();
            }
        }
    }
}
