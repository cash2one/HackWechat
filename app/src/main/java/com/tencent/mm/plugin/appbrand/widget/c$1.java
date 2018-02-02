package com.tencent.mm.plugin.appbrand.widget;

class c$1 implements Runnable {
    final /* synthetic */ String jUC;
    final /* synthetic */ String jUD;
    final /* synthetic */ String jUE;
    final /* synthetic */ String jUF;
    final /* synthetic */ c jUG;

    c$1(c cVar, String str, String str2, String str3, String str4) {
        this.jUG = cVar;
        this.jUC = str;
        this.jUD = str2;
        this.jUE = str3;
        this.jUF = str4;
    }

    public final void run() {
        c.a(this.jUG, this.jUC, this.jUD);
        c.b(this.jUG, this.jUE, this.jUF);
        c.a(this.jUG);
    }
}
