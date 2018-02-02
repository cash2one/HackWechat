package com.tencent.mm.plugin.offline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak.a;

class g$2 implements a {
    final /* synthetic */ g oVG;

    g$2(g gVar) {
        this.oVG = gVar;
    }

    public final boolean uF() {
        if (g.a(this.oVG) != null) {
            if (!g.Dh().Cy()) {
                long apD = (long) g.apD();
                g.a(this.oVG).J(apD, apD);
            } else if (com.tencent.mm.plugin.offline.c.a.bij() && com.tencent.mm.plugin.offline.c.a.bhH()) {
                g.bgU();
            }
        }
        return false;
    }
}
