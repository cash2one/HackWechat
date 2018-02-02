package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class p$1 implements Runnable {
    final /* synthetic */ String gIx;
    final /* synthetic */ p tiZ;

    public p$1(p pVar, String str) {
        this.tiZ = pVar;
        this.gIx = str;
    }

    public final void run() {
        p.a(this.tiZ, new c(p.bz(), this.gIx, p.a(this.tiZ)));
        ar.CG().a(349, this.tiZ);
        x.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
    }
}
