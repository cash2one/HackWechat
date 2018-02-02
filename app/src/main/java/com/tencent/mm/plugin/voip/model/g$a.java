package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$a implements Runnable {
    private c nEC = null;
    private b nEj = null;
    final /* synthetic */ g skP;

    public g$a(g gVar, b bVar, c cVar) {
        this.skP = gVar;
        this.nEj = bVar;
        this.nEC = cVar;
    }

    public final void run() {
        if (this.nEj != null) {
            this.nEj.bGf();
            this.nEj.bGc();
            this.nEj = null;
        }
        x.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
        if (this.nEC != null) {
            this.nEC.vi();
            this.nEC = null;
        }
    }
}
