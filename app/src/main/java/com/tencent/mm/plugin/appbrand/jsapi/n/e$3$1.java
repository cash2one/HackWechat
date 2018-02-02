package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.n.e.3;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$3$1 implements b {
    final /* synthetic */ 3 jvi;

    e$3$1(3 3) {
        this.jvi = 3;
    }

    public final void sS(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
        } else {
            e.c(this.jvi.jvd, str);
        }
    }
}
