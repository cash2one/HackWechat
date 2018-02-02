package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.report.a.a;

class n$2 implements Runnable {
    final /* synthetic */ n jDp;
    final /* synthetic */ boolean[] jDq;
    final /* synthetic */ aa jDr;
    final /* synthetic */ l jDs;

    n$2(n nVar, boolean[] zArr, aa aaVar, l lVar) {
        this.jDp = nVar;
        this.jDq = zArr;
        this.jDr = aaVar;
        this.jDs = lVar;
    }

    public final void run() {
        p pVar = null;
        this.jDq[0] = true;
        if (this.jDp.getPageCount() != 0) {
            l lVar;
            if (n.a(this.jDp).isEmpty()) {
                lVar = null;
            } else {
                lVar = (l) n.a(this.jDp).getFirst();
            }
            if (this.jDr == aa.jFK || this.jDr == aa.jFI || this.jDr == aa.jFJ) {
                n.a(this.jDp, lVar);
            }
            boolean b = n.b(this.jDr);
            n.a(this.jDp, lVar, b, n.c(this.jDr));
            n.a(this.jDp, this.jDs, b);
            a b2 = n.b(this.jDp);
            p aex = this.jDs.aex();
            if (lVar != null) {
                pVar = lVar.aex();
            }
            b2.a(aex, pVar, this.jDr);
        }
    }
}
