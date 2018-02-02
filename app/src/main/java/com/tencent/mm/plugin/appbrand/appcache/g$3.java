package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.x;

class g$3 extends c {
    final /* synthetic */ g iDU;

    g$3(g gVar) {
        this.iDU = gVar;
    }

    public final void enter() {
        super.enter();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        w.cq(true);
        g.Di().gPJ.a(1168, new 1(this));
    }
}
