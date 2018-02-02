package com.tencent.mm.plugin.appbrand.jsapi;

class d$2 implements Runnable {
    final /* synthetic */ String iTF;
    final /* synthetic */ d jbR;
    final /* synthetic */ String jbS;
    final /* synthetic */ int jbT;

    d$2(d dVar, String str, String str2, int i) {
        this.jbR = dVar;
        this.jbS = str;
        this.iTF = str2;
        this.jbT = i;
    }

    public final void run() {
        if (this.jbR.Vx) {
            d.a(this.jbR, this.jbS, this.iTF, this.jbT, false);
        }
    }
}
