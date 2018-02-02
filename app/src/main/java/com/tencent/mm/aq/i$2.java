package com.tencent.mm.aq;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements Runnable {
    final /* synthetic */ i hBd;
    final /* synthetic */ l hBf;

    i$2(i iVar, l lVar) {
        this.hBd = iVar;
        this.hBf = lVar;
    }

    public final void run() {
        x.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(i.b(this.hBd)), Integer.valueOf(this.hBf.hashCode()));
        if (i.b(this.hBd)) {
            i.a(this.hBd).offer(this.hBf);
            return;
        }
        g.Di().gPJ.a(this.hBf, 0);
        i.a(this.hBd, true);
    }
}
