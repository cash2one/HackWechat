package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2;
import com.tencent.mm.plugin.appbrand.widget.c.c.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiAuthorize$AuthorizeTask$2$1 implements a {
    final /* synthetic */ 2 jgc;

    JsApiAuthorize$AuthorizeTask$2$1(2 2) {
        this.jgc = 2;
    }

    public final void d(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
        switch (i) {
            case 1:
            case 2:
                this.jgc.jgb.jfW = "authorizeConfirm";
                this.jgc.jgb.jfV = bundle;
                this.jgc.jgb.jfY = i;
                AppBrandMainProcessService.a(this.jgc.jgb);
                if (i == 2) {
                    this.jgc.jgb.jfT.a(this.jgc.jgb.jcM, this.jgc.jgb.jcN, "fail auth deny");
                    this.jgc.jgb.jfU.afC();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.JsApiAuthorize", "press back button!");
                this.jgc.jgb.jfT.a(this.jgc.jgb.jcM, this.jgc.jgb.jcN, "fail auth cancel");
                this.jgc.jgb.jfU.afC();
                return;
        }
    }
}
