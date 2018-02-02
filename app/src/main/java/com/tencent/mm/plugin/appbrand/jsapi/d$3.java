package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c.a;
import com.tencent.mm.plugin.appbrand.permission.c.b;

class d$3 implements b {
    final /* synthetic */ int gOK;
    final /* synthetic */ d jbR;
    final /* synthetic */ String jbU;
    final /* synthetic */ String jbV;
    final /* synthetic */ boolean jbW;
    final /* synthetic */ e jbX;

    d$3(d dVar, String str, String str2, int i, boolean z, e eVar) {
        this.jbR = dVar;
        this.jbU = str;
        this.jbV = str2;
        this.gOK = i;
        this.jbW = z;
        this.jbX = eVar;
    }

    public final void a(a aVar) {
        if (this.jbR.jbL != null && this.jbR.jbL.isRunning()) {
            if (aVar.code == 1) {
                this.jbR.iTB.post(new 1(this));
            } else {
                this.jbR.jbL.E(this.gOK, this.jbX.e(aVar.fpb, null));
            }
        }
    }
}
