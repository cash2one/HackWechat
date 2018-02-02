package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.a;

class c$17 implements a {
    final /* synthetic */ c nXi;

    c$17(c cVar) {
        this.nXi = cVar;
    }

    public final void aWA() {
        x.d("MicroMsg.MMPoiMapUI", "back pressed");
        c.a(this.nXi, c.aWx(), c.v(this.nXi).nXs, true);
        c.a(this.nXi, null);
    }
}
