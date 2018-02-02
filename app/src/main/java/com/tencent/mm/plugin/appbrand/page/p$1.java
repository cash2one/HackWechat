package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.x;

class p$1 implements Runnable {
    final /* synthetic */ p jEg;

    p$1(p pVar) {
        this.jEg = pVar;
    }

    public final void run() {
        x.i("MicroMsg.AppBrandPageView", "[showErrorPageViewRunnable]showErrorPageView");
        this.jEg.aiZ();
    }
}
