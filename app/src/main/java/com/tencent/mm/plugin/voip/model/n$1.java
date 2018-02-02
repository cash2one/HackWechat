package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak.a;

class n$1 implements a {
    final /* synthetic */ n sny;

    n$1(n nVar) {
        this.sny = nVar;
    }

    public final boolean uF() {
        if (this.sny.siL.ske.soc == 1) {
            e eVar = this.sny.siL;
            boolean z = eVar.mStatus == 2 || eVar.mStatus == 4;
            if (z) {
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                this.sny.siL.ske.spH.skR = 101;
                g.pQN.h(11521, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                this.sny.bHD();
                this.sny.siL.skf.bGW();
            }
        }
        return false;
    }
}
