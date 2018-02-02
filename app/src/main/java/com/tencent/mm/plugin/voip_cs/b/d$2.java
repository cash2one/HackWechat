package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class d$2 implements a {
    final /* synthetic */ d sxb;

    d$2(d dVar) {
        this.sxb = dVar;
    }

    public final boolean uF() {
        x.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        ar.CG().a(795, this.sxb);
        ar.CG().a(new b(b.bIS().nEG.sod, b.bIS().nEG.nDy), 0);
        return true;
    }
}
