package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;
import java.io.File;

class JsApiChooseVideo$a$2 implements Runnable {
    final /* synthetic */ a jnv;

    JsApiChooseVideo$a$2(a aVar) {
        this.jnv = aVar;
    }

    public final void run() {
        if (new File(a.b(this.jnv)).exists()) {
            a.a(this.jnv).bjW = -1;
            a.a(this.jnv).jns = a.a(this.jnv, a.b(this.jnv), a.c(this.jnv).jnr);
            a.b(this.jnv, a.a(this.jnv));
            return;
        }
        a.a(this.jnv).bjW = -2;
        a.c(this.jnv, a.a(this.jnv));
    }
}
