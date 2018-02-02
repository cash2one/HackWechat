package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.gallery.i.a;

class i$12 implements Runnable {
    final /* synthetic */ i yFV;

    i$12(i iVar) {
        this.yFV = iVar;
    }

    public final void run() {
        i.h(this.yFV);
        i.a(this.yFV, i.i(this.yFV));
        i.d(this.yFV).bx(false);
        i.j(this.yFV);
        if (i.c(this.yFV)) {
            i.b(this.yFV, bh.Wp());
            i.f(this.yFV).cvn();
            i.f(this.yFV).reset();
            i.a(this.yFV, false);
            i.k(this.yFV);
        }
        t.d(i.a(this.yFV), 0, i.c(this.yFV));
        if (i.l(this.yFV) != null) {
            a aVar = (a) i.l(this.yFV).get(i.a(this.yFV));
            if (aVar != null) {
                j cuz = this.yFV.yCR.cuz();
                cuz.cvl().yGl.stop();
                i.a(this.yFV, 0);
                this.yFV.a(cuz, aVar.fnB, aVar.pos);
                this.yFV.Gh(0);
                if (cuz.cvl().yGt.getVisibility() != 8) {
                    cuz.cvl().yGt.setVisibility(8);
                }
            }
        }
    }
}
