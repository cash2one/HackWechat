package com.tencent.mm.plugin.appbrand.ui;

class h$1 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ String iaA;
    final /* synthetic */ h jNe;

    h$1(h hVar, int i, String str) {
        this.jNe = hVar;
        this.iGh = i;
        this.iaA = str;
    }

    public final void run() {
        h.a(this.jNe, this.iGh, this.iaA);
    }
}
