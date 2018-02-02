package com.tencent.mm.aq;

import com.tencent.mm.aq.l.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.x;

class l$b {
    final /* synthetic */ l hBQ;
    public a hBT;

    final void Pj() {
        e d;
        if (l.b(this.hBQ) == l.c(this.hBQ)) {
            d = l.d(this.hBQ);
        } else {
            d = l.e(this.hBQ);
        }
        if (d.hAb == 1) {
            f.vA(23);
            f.vA(21);
        }
        if (o.Pw().a(Long.valueOf(l.c(this.hBQ)), l.d(this.hBQ)) < 0) {
            x.e(l.f(this.hBQ), "update db failed local id:" + l.c(this.hBQ) + " server id:" + l.d(this.hBQ).fFo);
            i.hU((int) l.b(this.hBQ));
            i.hT((int) l.b(this.hBQ));
            l.g(this.hBQ).a(3, -1, "", this.hBQ);
        }
        if (l.c(this.hBQ) != l.b(this.hBQ)) {
            o.Pw().a(Long.valueOf(l.b(this.hBQ)), l.e(this.hBQ));
        }
        l.a(this.hBQ, l.c(this.hBQ));
        if (l.b(this.hBQ) != l.c(this.hBQ)) {
            l.a(this.hBQ, l.b(this.hBQ));
        }
        if (this.hBT != null) {
            this.hBT.Pj();
        }
        this.hBQ.hV(l.h(this.hBQ));
        l.i(this.hBQ);
    }

    public l$b(l lVar, a aVar) {
        this.hBQ = lVar;
        this.hBT = aVar;
    }
}
