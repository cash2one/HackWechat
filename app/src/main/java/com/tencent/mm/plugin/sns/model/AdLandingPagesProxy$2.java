package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;

class AdLandingPagesProxy$2 implements Runnable {
    final /* synthetic */ String hVh;
    final /* synthetic */ AdLandingPagesProxy qSq;

    AdLandingPagesProxy$2(AdLandingPagesProxy adLandingPagesProxy, String str) {
        this.qSq = adLandingPagesProxy;
        this.hVh = str;
    }

    public final void run() {
        if (g.Dh().Cy()) {
            m Ll = ae.bvv().Ll(this.hVh);
            if (Ll != null) {
                b bxR = Ll.bxR();
                if (bxR != null) {
                    AdLandingPagesProxy.a(this.qSq, bxR.bwB());
                    AdLandingPagesProxy.a(this.qSq, bxR.bwC());
                }
            }
        }
    }
}
