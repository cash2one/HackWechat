package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.config.d$a;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.l;
import java.util.Iterator;

class a$1 implements d$a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ a iZz;

    a$1(a aVar, j jVar, int i) {
        this.iZz = aVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void a(b bVar, boolean z) {
        this.iZy.E(this.gOK, this.iZz.e(z ? "ok" : "fail", null));
        if (z) {
            Iterator it = this.iZy.irP.iqC.jDj.iterator();
            while (it.hasNext()) {
                ((l) it.next()).aew();
            }
        }
    }
}
