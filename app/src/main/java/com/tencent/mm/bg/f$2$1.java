package com.tencent.mm.bg;

import com.tencent.mm.bg.f.2;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class f$2$1 implements Runnable {
    final /* synthetic */ 2 hYF;

    f$2$1(2 2) {
        this.hYF = 2;
    }

    public final void run() {
        x.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[]{Integer.valueOf(f.f(this.hYF.hYD)), Long.valueOf(System.currentTimeMillis())});
        if (f.g(this.hYF.hYD) || f.i(this.hYF.hYD) == null || f.f(this.hYF.hYD) == 0) {
            x.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
            return;
        }
        g.CG().a(235, this.hYF.hYD);
        if (!((b) f.i(this.hYF.hYD)).UP() || !g.CG().a(f.i(this.hYF.hYD), 0)) {
            this.hYF.hYD.bq(13, 131);
        }
    }
}
