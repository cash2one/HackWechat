package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.plugin.appbrand.dynamic.a.e;

class a$e$1 implements Runnable {
    final /* synthetic */ c iRB;
    final /* synthetic */ e iRG;

    a$e$1(e eVar, c cVar) {
        this.iRG = eVar;
        this.iRB = cVar;
    }

    public final void run() {
        this.iRB.onResume();
    }
}
