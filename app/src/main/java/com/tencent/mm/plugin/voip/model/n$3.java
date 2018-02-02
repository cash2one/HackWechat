package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.sdk.platformtools.ak.a;

class n$3 implements a {
    final /* synthetic */ n sny;

    n$3(n nVar) {
        this.sny = nVar;
    }

    public final boolean uF() {
        if (this.sny.siL.ske.nDx == 0) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", g.zh() + " roomId == 0 ");
            n.c(this.sny).TG();
        } else {
            if (this.sny.siL.mStatus >= 5) {
                new f(this.sny.siL.ske.nDx, this.sny.siL.ske.nDy, this.sny.siL.skp).bHM();
            }
        }
        return true;
    }
}
