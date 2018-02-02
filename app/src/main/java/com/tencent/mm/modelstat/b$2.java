package com.tencent.mm.modelstat;

import com.tencent.mm.storage.au;

class b$2 implements Runnable {
    final /* synthetic */ b hPD;
    final /* synthetic */ int hPE;
    final /* synthetic */ au heZ;

    b$2(b bVar, au auVar, int i) {
        this.hPD = bVar;
        this.heZ = auVar;
        this.hPE = i;
    }

    public final void run() {
        b.a(this.hPD, this.heZ, this.hPE);
    }
}
