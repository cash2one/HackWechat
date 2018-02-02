package com.tencent.mm.plugin.appbrand.ui;

class h$2 implements Runnable {
    final /* synthetic */ String gIn;
    final /* synthetic */ String iaA;
    final /* synthetic */ h jNe;

    h$2(h hVar, String str, String str2) {
        this.jNe = hVar;
        this.gIn = str;
        this.iaA = str2;
    }

    public final void run() {
        h.a(this.jNe, this.gIn, this.iaA);
    }
}
