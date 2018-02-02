package com.tencent.mm.ui;

import com.tencent.mm.aw.b;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.preference.IconPreference;

class y$3 implements a {
    final /* synthetic */ y xKX;
    final /* synthetic */ IconPreference xLa;

    y$3(y yVar, IconPreference iconPreference) {
        this.xKX = yVar;
        this.xLa = iconPreference;
    }

    public final void c(ay ayVar) {
        if (ayVar != null && ayVar.field_tipId == b.hId && com.tencent.mm.plugin.x.a.bfo().ig(b.hId)) {
            this.xLa.EZ(0);
            this.xLa.EX(8);
            this.xLa.dh("", -1);
        }
    }
}
