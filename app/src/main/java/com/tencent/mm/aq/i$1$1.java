package com.tencent.mm.aq;

import com.tencent.mm.aq.i.1;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class i$1$1 implements Runnable {
    final /* synthetic */ 1 hBe;

    i$1$1(1 1) {
        this.hBe = 1;
    }

    public final void run() {
        x.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.a(this.hBe.hBd).size());
        i.a(this.hBe.hBd, false);
        if (i.a(this.hBe.hBd).size() > 0) {
            l lVar = (l) i.a(this.hBe.hBd).poll();
            if (lVar != null) {
                x.i("MicroMsg.ImgService", "upload image scene hashcode : " + lVar.hashCode());
                g.Di().gPJ.a(lVar, 0);
                i.a(this.hBe.hBd, true);
                return;
            }
            x.w("MicroMsg.ImgService", "poll image scene is null");
        }
    }
}
