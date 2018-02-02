package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.c.a;
import com.tencent.smtt.sdk.d;
import org.xwalk.core.Log;

class h$2 implements a {
    final /* synthetic */ h ArU;

    h$2(h hVar) {
        this.ArU = hVar;
    }

    public final void a(d dVar) {
        Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[]{dVar.zVt.getMessage()}));
        if (this.ArU.jwz != null) {
            this.ArU.jwz.aJ(r0, "");
        }
    }
}
