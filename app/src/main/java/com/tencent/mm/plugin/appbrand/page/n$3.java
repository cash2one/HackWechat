package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.report.a.a;
import com.tencent.mm.plugin.appbrand.report.a.a.3;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements p$g {
    final /* synthetic */ long gyu;
    final /* synthetic */ n jDp;
    final /* synthetic */ boolean[] jDq;
    final /* synthetic */ aa jDr;
    final /* synthetic */ l jDs;
    final /* synthetic */ Runnable jDt;

    n$3(n nVar, l lVar, boolean[] zArr, Runnable runnable, long j, aa aaVar) {
        this.jDp = nVar;
        this.jDs = lVar;
        this.jDq = zArr;
        this.jDt = runnable;
        this.gyu = j;
        this.jDr = aaVar;
    }

    public final void onReady() {
        int i;
        int i2 = 2;
        this.jDs.aex().b(this);
        if (!this.jDq[0]) {
            this.jDp.removeCallbacks(this.jDt);
            this.jDp.post(this.jDt);
        }
        n.c(this.jDp);
        long currentTimeMillis = System.currentTimeMillis() - this.gyu;
        a b = n.b(this.jDp);
        switch (3.jHv[this.jDr.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
            case 3:
            case 4:
                i = 3;
                break;
            default:
                i = 2;
                break;
        }
        b.g(currentTimeMillis, i);
        g.pQN.a(390, 0, 1, false);
        switch (((int) currentTimeMillis) / 250) {
            case 0:
                i2 = 1;
                break;
            case 1:
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
            case 5:
                i2 = 5;
                break;
            case 6:
            case 7:
                i2 = 6;
                break;
            default:
                i2 = 7;
                break;
        }
        g.pQN.a(390, (long) i2, 1, false);
        x.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", Long.valueOf(currentTimeMillis));
    }
}
