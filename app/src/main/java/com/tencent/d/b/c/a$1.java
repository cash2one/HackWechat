package com.tencent.d.b.c;

import com.tencent.d.a.c.c;

class a$1 implements Runnable {
    final /* synthetic */ boolean AcG;
    final /* synthetic */ a AcH;

    a$1(a aVar, boolean z) {
        this.AcH = aVar;
        this.AcG = z;
    }

    public final void run() {
        c.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
        this.AcH.AcF.cancel();
        if (this.AcG) {
            a.cGc();
        }
    }
}
