package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ac$2 implements a {
    final /* synthetic */ long lrL;
    final /* synthetic */ ac yCz;

    ac$2(ac acVar, long j) {
        this.yCz = acVar;
        this.lrL = j;
    }

    public final boolean JC() {
        return false;
    }

    public final boolean JB() {
        ar.Hg();
        au dH = c.Fa().dH(this.lrL);
        dH.cjx();
        b.hPA.a(dH, true);
        ar.Hg();
        c.Fa().a(this.lrL, dH);
        return false;
    }
}
