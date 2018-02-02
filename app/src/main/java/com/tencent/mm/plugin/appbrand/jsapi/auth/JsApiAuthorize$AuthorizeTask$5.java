package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import com.tencent.mm.u.a.b.a;

class JsApiAuthorize$AuthorizeTask$5 implements a<b> {
    final /* synthetic */ int iTc;
    final /* synthetic */ AuthorizeTask jgb;
    final /* synthetic */ AuthorizeTask.a jgd;

    JsApiAuthorize$AuthorizeTask$5(AuthorizeTask authorizeTask, AuthorizeTask.a aVar, int i) {
        this.jgb = authorizeTask;
        this.jgd = aVar;
        this.iTc = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        b bVar = (b) kVar;
        x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jgd.afG();
        } else if (!(bVar instanceof b)) {
        } else {
            if (this.iTc == 2) {
                x.d("MicroMsg.JsApiAuthorize", "press reject button");
                return;
            }
            amh BW = bVar.BW();
            int i3 = BW.wte.fts;
            String str2 = BW.wte.ftt;
            x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                this.jgd.onSuccess();
                return;
            }
            x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
            this.jgd.afG();
        }
    }
}
