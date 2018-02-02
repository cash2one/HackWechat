package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.plugin.appbrand.dynamic.a.d;

class a$d$1 implements Runnable {
    final /* synthetic */ c iRB;
    final /* synthetic */ d iRF;

    a$d$1(d dVar, c cVar) {
        this.iRF = dVar;
        this.iRB = cVar;
    }

    public final void run() {
        this.iRB.onPause();
    }
}
