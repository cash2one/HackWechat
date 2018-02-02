package com.tencent.mm.plugin.appbrand.jsapi;

class d$1 implements Runnable {
    final /* synthetic */ String iTF;
    final /* synthetic */ String iXg;
    final /* synthetic */ String jbQ;
    final /* synthetic */ d jbR;

    d$1(d dVar, String str, String str2, String str3) {
        this.jbR = dVar;
        this.iXg = str;
        this.iTF = str2;
        this.jbQ = str3;
    }

    public final void run() {
        this.jbR.jbL.a(this.iXg, this.iTF, d.sd(this.jbQ));
    }
}
