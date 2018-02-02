package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class w$1 implements Runnable {
    final /* synthetic */ boolean iEU;

    w$1(boolean z) {
        this.iEU = z;
    }

    public final void run() {
        if (this.iEU) {
            x.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
            g.Dj().CU().a(a.xrF, Long.valueOf(bh.Wo() - 1));
        }
        w.ya();
    }
}
