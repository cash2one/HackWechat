package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;

class f$2 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ String jjY;
    final /* synthetic */ int jkb;
    final /* synthetic */ int jkc;
    final /* synthetic */ f jkd;
    final /* synthetic */ e jke;

    f$2(f fVar, p pVar, int i, int i2, String str, e eVar, int i3) {
        this.jkd = fVar;
        this.jdJ = pVar;
        this.jkb = i;
        this.jkc = i2;
        this.jjY = str;
        this.jke = eVar;
        this.gOK = i3;
    }

    public final void run() {
        f.a(this.jkd, this.jdJ, this.jkb, this.jkc, this.jjY, this.jke, this.gOK);
    }
}
