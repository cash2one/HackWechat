package com.tencent.mm.bg;

import com.tencent.mm.bg.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ a hYd;
    final /* synthetic */ b hYe;

    b$1(b bVar, a aVar) {
        this.hYe = bVar;
        this.hYd = aVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[]{this.hYd.hYK, Integer.valueOf(this.hYd.hYN), Integer.valueOf(this.hYe.hashCode())});
        g.CG().a(this.hYe, 0);
    }
}
