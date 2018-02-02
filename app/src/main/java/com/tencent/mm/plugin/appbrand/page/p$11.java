package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.d;

class p$11 implements Runnable {
    final /* synthetic */ p jEg;

    p$11(p pVar) {
        this.jEg = pVar;
    }

    public final void run() {
        for (d afA : this.jEg.jDI) {
            afA.afA();
        }
    }
}
