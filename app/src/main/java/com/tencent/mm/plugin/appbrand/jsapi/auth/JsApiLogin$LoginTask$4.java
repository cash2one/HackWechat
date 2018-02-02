package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.c;
import com.tencent.mm.u.a.c.a;
import java.util.LinkedList;

class JsApiLogin$LoginTask$4 implements a<c> {
    final /* synthetic */ LoginTask jgf;
    final /* synthetic */ LoginTask.a jgh;

    JsApiLogin$LoginTask$4(LoginTask loginTask, LoginTask.a aVar) {
        this.jgf = loginTask;
        this.jgh = aVar;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        c cVar = (c) kVar;
        x.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && cVar != null) {
            amn BX = cVar.BX();
            int i3 = BX.wte.fts;
            String str2 = BX.wte.ftt;
            String str3 = BX.wtg;
            x.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                LinkedList linkedList = BX.whQ;
                x.i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", new Object[]{BX.niZ, BX.vFW});
                this.jgh.a(linkedList, str2, r0, str3);
                return;
            } else if (i3 == 0) {
                this.jgh.po(BX.wth);
                x.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                return;
            } else if (i3 == -12001) {
                this.jgh.afG();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", new Object[]{str2});
                return;
            } else if (i3 == -12002) {
                this.jgh.afG();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", new Object[]{str2});
                return;
            } else if (i3 == -12003) {
                this.jgh.afG();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", new Object[]{str2});
                return;
            } else {
                this.jgh.afG();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                return;
            }
        }
        this.jgh.afG();
    }
}
