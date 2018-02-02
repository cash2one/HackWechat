package com.tencent.mm.plugin.h;

import com.tencent.mm.av.b;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ai;
import com.tencent.mm.z.ar;

public final class e extends a {
    private ai hfQ;

    static /* synthetic */ boolean arw() {
        if (b.Qq()) {
            return false;
        }
        com.tencent.mm.sdk.b.b riVar = new ri();
        riVar.fJc.fJe = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        return bh.ov(riVar.fJd.fJg);
    }

    public e(ai aiVar) {
        this.hfQ = aiVar;
    }

    public final void execute(g gVar) {
        ar.a(this.hfQ, new 1(this));
    }
}
