package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.n.6;
import com.tencent.mm.sdk.f.e;

class n$4 implements f$a {
    final /* synthetic */ n ovP;

    n$4(n nVar) {
        this.ovP = nVar;
    }

    public final void baI() {
        e.post(new 6(this.ovP), "MMSightMediaCodecMP4MuxRecorder_stop");
    }
}
