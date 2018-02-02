package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.modelmulti.r.f;

class r$2 implements Runnable {
    final /* synthetic */ r hHn;
    final /* synthetic */ c hHo;

    r$2(r rVar, c cVar) {
        this.hHn = rVar;
        this.hHo = cVar;
    }

    public final void run() {
        if (this.hHo != null) {
            if (this.hHo instanceof f) {
                r.b(this.hHn).add(this.hHo);
            } else {
                r.c(this.hHn).add(this.hHo);
            }
        }
        r.b(this.hHn, null);
    }
}
