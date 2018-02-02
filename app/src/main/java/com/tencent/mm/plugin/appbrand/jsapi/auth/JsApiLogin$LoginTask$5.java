package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.d;
import com.tencent.mm.u.a.d.a;

class JsApiLogin$LoginTask$5 implements a<d> {
    final /* synthetic */ int iTc;
    final /* synthetic */ LoginTask jgf;
    final /* synthetic */ LoginTask.a jgh;

    JsApiLogin$LoginTask$5(LoginTask loginTask, LoginTask.a aVar, int i) {
        this.jgf = loginTask;
        this.jgh = aVar;
        this.iTc = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        d dVar = (d) kVar;
        x.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jgh.afG();
        } else if (!(dVar instanceof d)) {
            x.i("MicroMsg.JsApiLogin", "not jslogin cgi reqeust");
            this.jgh.afG();
        } else if (this.iTc == 2) {
            x.i("MicroMsg.JsApiLogin", "press reject button");
            this.jgh.afG();
        } else {
            aml BY = dVar.BY();
            int i3 = BY.wte.fts;
            String str2 = BY.wte.ftt;
            x.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                this.jgh.po(BY.wth);
                x.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                return;
            }
            this.jgh.afG();
            x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
        }
    }
}
