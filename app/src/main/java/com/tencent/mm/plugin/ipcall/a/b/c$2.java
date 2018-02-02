package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c nEB;

    c$2(c cVar) {
        this.nEB = cVar;
    }

    public final void run() {
        try {
            c cVar = this.nEB;
            cVar.nEu = new c(v2protocal.oFK, 1, 6);
            cVar.nEu.et(20);
            cVar.nEu.aP(true);
            cVar.nEu.vq();
            cVar.nEu.fkz = -19;
            cVar.nEu.n(1, false);
            cVar.nEu.aO(true);
            cVar.nEu.fkK = cVar.nEA;
            if (cVar.nEu.vr()) {
                cVar.nEu.aQ(cVar.kTc);
                return;
            }
            x.e("MicroMsg.IPCallRecorder", "start record failed");
            if (cVar.nEu.fkp != 13) {
                i.aTz().aTY();
            }
        } catch (Exception e) {
            x.e("MicroMsg.IPCallRecorder", "start record error: %s", e.getMessage());
            i.aTz().aTY();
        }
    }
}
