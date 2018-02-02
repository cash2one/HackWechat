package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.p.c;

class n$15 implements a {
    final /* synthetic */ String jDC;
    final /* synthetic */ aa jDD;
    final /* synthetic */ n jDp;

    n$15(n nVar, String str, aa aaVar) {
        this.jDp = nVar;
        this.jDC = str;
        this.jDD = aaVar;
    }

    public final void a(c cVar) {
        if (c.CANCEL != cVar) {
            n.a(this.jDp, new 1(this));
        }
    }
}
