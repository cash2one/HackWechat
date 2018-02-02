package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;

class g$3 implements Runnable {
    final /* synthetic */ g skP;

    g$3(g gVar) {
        this.skP = gVar;
    }

    public final void run() {
        try {
            g.k(this.skP);
        } catch (Exception e) {
            x.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[]{e.getMessage()});
            this.skP.skL = 1;
            this.skP.siL.yu(this.skP.skL);
        }
    }
}
