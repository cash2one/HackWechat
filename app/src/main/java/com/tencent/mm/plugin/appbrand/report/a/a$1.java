package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.page.p;

class a$1 implements Runnable {
    final /* synthetic */ p jHs;
    final /* synthetic */ p jHt;
    final /* synthetic */ a jHu;

    a$1(a aVar, p pVar, p pVar2) {
        this.jHu = aVar;
        this.jHs = pVar;
        this.jHt = pVar2;
    }

    public final void run() {
        this.jHu.a(this.jHs, this.jHt);
    }
}
