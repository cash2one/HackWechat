package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.az.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.bh;

class d$3 implements Runnable {
    final /* synthetic */ d jxE;
    final /* synthetic */ String jxF;

    d$3(d dVar, String str) {
        this.jxE = dVar;
        this.jxF = str;
    }

    public final void run() {
        String[] qP = q.qP(this.jxF);
        if (qP != null && qP.length > 0) {
            for (String str : qP) {
                b Jj = b.Jj();
                if (!bh.ov(str)) {
                    Jj.a(new b.b(), str, null);
                }
            }
        }
        if (g.Dj().isSDCardAvailable()) {
            g.Di().gPJ.a(new k(12), 0);
        }
    }
}
