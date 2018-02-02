package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<hl> {
    public b() {
        this.xen = hl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        hl hlVar = (hl) bVar;
        if (hlVar instanceof hl) {
            x.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            x.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", Boolean.valueOf(h.bCT()));
            if (h.bCT()) {
                hlVar.fxN.fxO = 1;
            } else {
                hlVar.fxN.fxO = 0;
            }
        }
        return true;
    }
}
