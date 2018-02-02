package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.bo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class a$1 implements Runnable {
    final /* synthetic */ bo myX;
    final /* synthetic */ a myY;

    a$1(a aVar, bo boVar) {
        this.myY = aVar;
        this.myX = boVar;
    }

    public final void run() {
        if (this.myX.fpI == null) {
            return;
        }
        if (this.myX.fpI.retCode == 0) {
            x.i("MicroMsg.BaseFingerprintImp", "close finger print success!");
            if (q.Gf()) {
                x.i("MicroMsg.BaseFingerprintImp", "now context is isPayUPay!");
                return;
            }
            x.i("MicroMsg.BaseFingerprintImp", "do bound query, update data");
            g.Dk();
            g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, 19), 0);
            return;
        }
        x.i("MicroMsg.BaseFingerprintImp", "close finger print failed!");
    }
}
