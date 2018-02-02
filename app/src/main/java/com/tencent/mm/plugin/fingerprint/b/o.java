package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    a mzG;

    public o(a aVar) {
        this.mzG = aVar;
    }

    public final void aKE() {
        e.post(new Runnable(this) {
            final /* synthetic */ o mzH;

            {
                this.mzH = r1;
            }

            public final void run() {
                String str = "";
                if (e.aKi()) {
                    x.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.cE(ac.getContext()), e.getUserId(), q.yF());
                } else {
                    x.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (this.mzH.mzG != null) {
                    this.mzH.mzG.sj(str);
                }
            }
        }, getClass().getName());
    }
}
