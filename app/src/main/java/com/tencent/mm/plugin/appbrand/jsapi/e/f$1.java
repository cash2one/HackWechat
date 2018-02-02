package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;

class f$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jjZ;
    final /* synthetic */ int jkb;
    final /* synthetic */ int jkc;
    final /* synthetic */ f jkd;

    f$1(f fVar, p pVar, int i, int i2, int i3, int i4) {
        this.jkd = fVar;
        this.jdJ = pVar;
        this.jjZ = i;
        this.jkb = i2;
        this.jkc = i3;
        this.gOK = i4;
    }

    public final void run() {
        if (m.a(this.jdJ, this.jjZ, this.jkb, this.jkc)) {
            this.jdJ.E(this.gOK, this.jkd.e("ok", null));
        } else {
            this.jdJ.E(this.gOK, this.jkd.e("fail:invalid data", null));
        }
    }
}
