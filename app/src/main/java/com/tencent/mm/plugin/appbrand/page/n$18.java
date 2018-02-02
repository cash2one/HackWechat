package com.tencent.mm.plugin.appbrand.page;

class n$18 implements Runnable {
    final /* synthetic */ n jDp;
    final /* synthetic */ l jDs;

    n$18(n nVar, l lVar) {
        this.jDp = nVar;
        this.jDs = lVar;
    }

    public final void run() {
        n.a(this.jDp, n.a(this.jDp).indexOf(this.jDs) + 1);
    }
}
