package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.g;

class p$9 implements Runnable {
    final /* synthetic */ p jEg;

    p$9(p pVar) {
        this.jEg = pVar;
    }

    public final void run() {
        for (g onReady : this.jEg.jDH) {
            onReady.onReady();
        }
    }
}
