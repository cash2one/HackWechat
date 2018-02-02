package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.sdk.platformtools.bh;

class c$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ String hMZ;
    final /* synthetic */ j iZy;
    final /* synthetic */ String icx;
    final /* synthetic */ String jpX;
    final /* synthetic */ Boolean jpY;
    final /* synthetic */ String jpZ;
    final /* synthetic */ int jqa;
    final /* synthetic */ int jqb;
    final /* synthetic */ c jqc;

    c$1(c cVar, j jVar, String str, String str2, String str3, int i, Boolean bool, String str4, int i2, int i3) {
        this.jqc = cVar;
        this.iZy = jVar;
        this.icx = str;
        this.hMZ = str2;
        this.jpX = str3;
        this.gOK = i;
        this.jpY = bool;
        this.jpZ = str4;
        this.jqa = i2;
        this.jqb = i3;
    }

    public final void run() {
        if (this.iZy.Vx) {
            h bVar = new b(this.jqc.a(this.iZy));
            if (!bh.ov(this.icx)) {
                bVar.setTitle(this.icx);
            }
            bVar.setMessage(this.hMZ);
            bVar.a(this.jpX, true, new 1(this));
            if (this.jpY.booleanValue()) {
                bVar.b(this.jpZ, false, new 2(this));
            }
            bVar.setOnCancelListener(new 3(this));
            bVar.Ex(this.jqa);
            if (this.jpY.booleanValue()) {
                bVar.Ey(this.jqb);
            }
            this.iZy.irP.a(bVar);
        }
    }
}
