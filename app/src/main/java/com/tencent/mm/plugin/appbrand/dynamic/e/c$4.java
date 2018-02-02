package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.plugin.appbrand.dynamic.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView$b;

class c$4 implements WebView$b {
    c$4() {
    }

    public final void tH() {
        x.i("MicroMsg.JSEngineInitializer", "onCoreInitFinished");
        c.ID();
        for (a Za : c.acW()) {
            Za.Za();
        }
    }

    public final void tI() {
        x.i("MicroMsg.JSEngineInitializer", "onCoreInitFailed");
    }
}
