package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.sdk.platformtools.x;

class q$2 implements a {
    final /* synthetic */ String icE;

    q$2(String str) {
        this.icE = str;
    }

    public final void po(String str) {
        x.i("MicroMsg.SourceMapInjector", "Inject '%s' Script Success: %s", new Object[]{this.icE, str});
    }

    public final void fq(String str) {
        x.e("MicroMsg.SourceMapInjector", "Inject '%s' Script Failed: %s", new Object[]{this.icE, str});
    }
}
