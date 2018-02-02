package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.e;

class p$13 implements Runnable {
    final /* synthetic */ p jEg;

    p$13(p pVar) {
        this.jEg = pVar;
    }

    public final void run() {
        for (e onDestroy : this.jEg.jDK) {
            onDestroy.onDestroy();
        }
    }
}
