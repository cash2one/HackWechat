package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b jRN;

    b$1(b bVar) {
        this.jRN = bVar;
    }

    public final void alG() {
        x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        k.se(this.jRN.appId);
    }
}
