package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;

class d$1 implements Runnable {
    final /* synthetic */ d iZB;
    final /* synthetic */ j iZy;

    d$1(d dVar, j jVar) {
        this.iZB = dVar;
        this.iZy = jVar;
    }

    public final void run() {
        p b = d.b(this.iZy);
        if (b != null) {
            a bF = a.bF(b.getContentView());
            if (bF != null) {
                bF.hide();
            }
        }
    }
}
