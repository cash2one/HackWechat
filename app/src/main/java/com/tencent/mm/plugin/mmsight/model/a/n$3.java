package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements a {
    final /* synthetic */ n ovP;

    n$3(n nVar) {
        this.ovP = nVar;
    }

    public final void bat() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
        if (this.ovP.ouR.owk != c.ouh) {
            x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            return;
        }
        r rVar = this.ovP.ovG;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Start");
        rVar.fAs = true;
        rVar.startTime = System.currentTimeMillis();
        this.ovP.ouR.a(c.oua);
    }
}
