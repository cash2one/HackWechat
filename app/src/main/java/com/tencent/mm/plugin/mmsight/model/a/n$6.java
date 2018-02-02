package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class n$6 implements Runnable {
    final /* synthetic */ n ovP;

    n$6(n nVar) {
        this.ovP = nVar;
    }

    public final void run() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[]{Boolean.valueOf(this.ovP.baP())});
        if (!this.ovP.baP()) {
            SightVideoJNI.releaseBigSightDataBuffer(this.ovP.ouk);
            if (this.ovP.ovo != null) {
                ag.y(new 1(this));
            }
        } else if (this.ovP.ovN != null) {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
            ag.y(this.ovP.ovN);
        }
    }
}
