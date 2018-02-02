package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;

class JsApiChooseVideo$a$3 implements Runnable {
    final /* synthetic */ a jnv;
    final /* synthetic */ String jnw;

    JsApiChooseVideo$a$3(a aVar, String str) {
        this.jnv = aVar;
        this.jnw = str;
    }

    public final void run() {
        a.a(this.jnv).bjW = -1;
        a.a(this.jnv).jns = a.a(this.jnv, this.jnw, a.c(this.jnv).jnr);
        a.d(this.jnv, a.a(this.jnv));
    }
}
