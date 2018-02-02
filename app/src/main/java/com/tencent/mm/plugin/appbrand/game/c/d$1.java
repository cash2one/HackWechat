package com.tencent.mm.plugin.appbrand.game.c;

import java.util.LinkedList;

class d$1 implements Runnable {
    final /* synthetic */ String iTF;
    final /* synthetic */ d iYE;

    d$1(d dVar, String str) {
        this.iYE = dVar;
        this.iTF = str;
    }

    public final void run() {
        if (d.a(this.iYE) != null) {
            b a = d.a(this.iYE);
            String str = this.iTF;
            if (a.iYs) {
                a.rL(str);
                return;
            }
            if (a.iYr == null) {
                a.iYr = new LinkedList();
            }
            a.iYr.add(str);
        }
    }
}
