package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.e;

class f$1 implements Runnable {
    final /* synthetic */ e iCN;
    final /* synthetic */ int jMV;
    final /* synthetic */ Runnable jyU;

    f$1(e eVar, int i, Runnable runnable) {
        this.iCN = eVar;
        this.jMV = i;
        this.jyU = runnable;
    }

    public final void run() {
        f.a(this.iCN, this.jMV, this.jyU);
    }
}
