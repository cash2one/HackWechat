package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.alw;

class JsApiLaunchApplication$1$2 implements Runnable {
    final /* synthetic */ 1 jdi;
    final /* synthetic */ alw jdj;
    final /* synthetic */ a jdk;
    final /* synthetic */ Intent val$intent;

    JsApiLaunchApplication$1$2(1 1, Intent intent, alw com_tencent_mm_protocal_c_alw, a aVar) {
        this.jdi = 1;
        this.val$intent = intent;
        this.jdj = com_tencent_mm_protocal_c_alw;
        this.jdk = aVar;
    }

    public final void run() {
        this.jdk.cH(g.a(this.jdi.iZy.getContext(), this.val$intent, null, this.jdj.wsR, this.jdk, this.jdi.jdd));
    }
}
