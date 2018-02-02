package com.tencent.mm.network;

import com.tencent.mm.kernel.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class t$3 implements Runnable {
    final /* synthetic */ t hZT;

    t$3(t tVar) {
        this.hZT = tVar;
    }

    public final void run() {
        x.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
        aa.VR().e(4, -100, ac.getContext().getString(a.gRe));
    }
}
