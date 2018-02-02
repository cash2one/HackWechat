package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d sxb;

    d$1(d dVar) {
        this.sxb = dVar;
    }

    public final boolean uF() {
        x.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        this.sxb.bIY();
        return true;
    }
}
