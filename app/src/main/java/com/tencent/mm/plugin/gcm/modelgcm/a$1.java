package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a nyo;

    a$1(a aVar) {
        this.nyo = aVar;
    }

    public final void run() {
        x.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
        a aSa = a.aSa();
        if (aSa != null) {
            aSa.aSc();
        }
    }
}
