package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiAuthorize$AuthorizeTask$1 implements a {
    final /* synthetic */ AuthorizeTask jgb;

    JsApiAuthorize$AuthorizeTask$1(AuthorizeTask authorizeTask) {
        this.jgb = authorizeTask;
    }

    public final void onSuccess() {
        x.d("MicroMsg.JsApiAuthorize", "onSuccess !");
        this.jgb.jfX = "ok";
        AuthorizeTask.a(this.jgb);
    }

    public final void afG() {
        x.e("MicroMsg.JsApiAuthorize", "onFailure !");
        this.jgb.jfX = "fail";
        AuthorizeTask.b(this.jgb);
    }

    public final void a(LinkedList<bec> linkedList, String str, String str2) {
        x.d("MicroMsg.JsApiAuthorize", "onConfirm !");
        this.jgb.jfZ = linkedList.size();
        int i = 0;
        while (i < this.jgb.jfZ) {
            try {
                this.jgb.jga.putByteArray(String.valueOf(i), ((bec) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                this.jgb.jfX = "fail";
                AuthorizeTask.c(this.jgb);
                return;
            }
        }
        this.jgb.mAppName = str;
        this.jgb.iVz = str2;
        this.jgb.jfX = "needConfirm";
        AuthorizeTask.d(this.jgb);
    }
}
