package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.permission.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$c$1 implements Runnable {
    final /* synthetic */ c jGA;

    b$c$1(c cVar) {
        this.jGA = cVar;
    }

    public final void run() {
        Runnable runnable = (Runnable) b.ajw().pollFirst();
        if (runnable != null) {
            runnable.run();
            return;
        }
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
        b.de(false);
    }
}
