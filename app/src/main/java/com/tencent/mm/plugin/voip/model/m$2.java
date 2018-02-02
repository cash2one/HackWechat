package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.k.f;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements Runnable {
    final /* synthetic */ long saA;
    final /* synthetic */ int saz;
    final /* synthetic */ m sni;

    m$2(m mVar, int i, long j) {
        this.sni = mVar;
        this.saz = i;
        this.saA = j;
    }

    public final void run() {
        x.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[]{Integer.valueOf(this.saz), Long.valueOf(this.saA)});
        if (!f.zp() && !m.dC(ac.getContext())) {
            x.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
        } else if (this.sni.smS.bHA()) {
            x.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg");
        } else {
            new e(this.saz, this.saA, "").bHM();
        }
    }
}
