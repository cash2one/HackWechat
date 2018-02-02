package com.tencent.mm.modelvoice;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;

class r$1 implements Runnable {
    final /* synthetic */ c hWA;
    final /* synthetic */ p hXK;
    final /* synthetic */ r hXL;

    r$1(r rVar, c cVar, p pVar) {
        this.hXL = rVar;
        this.hWA = cVar;
        this.hXK = pVar;
    }

    public final void run() {
        this.hWA.A(((h) g.h(h.class)).aZi().F(this.hXK.fDC, this.hXK.fFo));
    }
}
