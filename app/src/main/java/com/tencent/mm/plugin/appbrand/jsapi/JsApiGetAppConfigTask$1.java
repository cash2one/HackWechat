package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.m.c;

class JsApiGetAppConfigTask$1 implements c {
    final /* synthetic */ JsApiGetAppConfigTask jcX;

    JsApiGetAppConfigTask$1(JsApiGetAppConfigTask jsApiGetAppConfigTask) {
        this.jcX = jsApiGetAppConfigTask;
    }

    public final void pL(String str) {
        this.jcX.value = str;
        JsApiGetAppConfigTask.a(this.jcX);
    }
}
