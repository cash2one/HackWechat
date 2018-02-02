package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiLogin$LoginTask$1 implements a {
    final /* synthetic */ LoginTask jgf;

    JsApiLogin$LoginTask$1(LoginTask loginTask) {
        this.jgf = loginTask;
    }

    public final void po(String str) {
        x.i("MicroMsg.JsApiLogin", "onSuccess !");
        this.jgf.code = str;
        this.jgf.jfX = "ok";
        LoginTask.a(this.jgf);
    }

    public final void afG() {
        x.i("MicroMsg.JsApiLogin", "onFailure !");
        this.jgf.jfX = "fail";
        LoginTask.b(this.jgf);
    }

    public final void a(LinkedList<bec> linkedList, String str, String str2, String str3) {
        x.i("MicroMsg.JsApiLogin", "onConfirm !");
        this.jgf.jfZ = linkedList.size();
        int i = 0;
        while (i < this.jgf.jfZ) {
            try {
                this.jgf.jga.putByteArray(String.valueOf(i), ((bec) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiLogin", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                this.jgf.jfX = "fail";
                LoginTask.c(this.jgf);
                return;
            }
        }
        this.jgf.jdO = str3;
        this.jgf.mAppName = str;
        this.jgf.iVz = str2;
        this.jgf.jfX = "needConfirm";
        LoginTask.d(this.jgf);
    }
}
