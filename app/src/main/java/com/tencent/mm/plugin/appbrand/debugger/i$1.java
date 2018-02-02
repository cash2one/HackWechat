package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.debugger.p.a;

class i$1 implements a {
    final /* synthetic */ i iQE;

    i$1(i iVar) {
        this.iQE = iVar;
    }

    public final void aco() {
        this.iQE.destroy();
        c.a(this.iQE.iqB.mAppId, c$c.CLOSE);
        this.iQE.iQz.finish();
    }
}
