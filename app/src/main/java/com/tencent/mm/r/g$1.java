package com.tencent.mm.r;

import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ g gJW;

    g$1(g gVar) {
        this.gJW = gVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneGetFuncMsg", "do retry");
        if (this.gJW.a(this.gJW.hmA, this.gJW.gJT) == -1) {
            this.gJW.gJT.a(3, -1, "doScene failed", this.gJW);
        }
    }
}
