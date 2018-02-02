package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class a$d$3 implements Runnable {
    final /* synthetic */ d jPE;
    final /* synthetic */ i jPF;

    a$d$3(d dVar, i iVar) {
        this.jPE = dVar;
        this.jPF = iVar;
    }

    public final void run() {
        f.Zn().h(this.jPF.fnl, this.jPF.iGA, true);
        a.a(this.jPF.appId, this.jPF.iGA + 1, 2, 1, a.t(this.jPE.jPj));
    }
}
