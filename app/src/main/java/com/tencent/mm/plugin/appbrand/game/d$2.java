package com.tencent.mm.plugin.appbrand.game;

class d$2 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ String iTF;
    final /* synthetic */ d iXf;

    d$2(d dVar, int i, String str) {
        this.iXf = dVar;
        this.gOK = i;
        this.iTF = str;
    }

    public final void run() {
        d.a(this.iXf, this.gOK, this.iTF);
    }
}
