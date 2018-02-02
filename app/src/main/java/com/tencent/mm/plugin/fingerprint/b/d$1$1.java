package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.plugin.fingerprint.b.d.1;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements Runnable {
    final /* synthetic */ 1 mzf;

    d$1$1(1 1) {
        this.mzf = 1;
    }

    public final void run() {
        try {
            d.aKg();
        } catch (UnsatisfiedLinkError e) {
            x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
            x.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e2.getMessage());
        }
    }
}
