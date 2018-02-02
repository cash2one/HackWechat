package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;

class c$3 implements b {
    final /* synthetic */ c nXi;

    c$3(c cVar) {
        this.nXi = cVar;
    }

    public final void aWy() {
    }

    public final void DO(String str) {
        x.d("MicroMsg.MMPoiMapUI", "searchText: %s", new Object[]{str});
        c.a(this.nXi, str);
        c.w(this.nXi).cpq();
        c.y(this.nXi).setVisibility(8);
        if (bh.ov(str)) {
            c.v(this.nXi).clean();
            c.v(this.nXi).notifyDataSetChanged();
            return;
        }
        c.z(this.nXi);
    }

    public final void Xt() {
        x.d("MicroMsg.MMPoiMapUI", "clear btn click");
        c.v(this.nXi).clean();
        c.v(this.nXi).notifyDataSetChanged();
    }

    public final void aWz() {
    }
}
