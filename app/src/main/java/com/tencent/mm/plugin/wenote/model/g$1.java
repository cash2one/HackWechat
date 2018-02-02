package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.c.ve;

class g$1 implements Runnable {
    final /* synthetic */ ve tQQ;
    final /* synthetic */ g tQR;

    public g$1(g gVar, ve veVar) {
        this.tQR = gVar;
        this.tQQ = veVar;
    }

    public final void run() {
        f fVar = new f();
        fVar.field_localId = g.a(this.tQR);
        fVar.field_favProto = this.tQQ;
        this.tQR.tQz = fVar.field_favProto;
        this.tQR.tQq = fVar;
        g.a(this.tQR, fVar);
        if (g.aQi().containsKey(g.b(this.tQR))) {
            this.tQR.tQp = (l) g.aQi().get(g.b(this.tQR));
        } else {
            g.c(this.tQR);
        }
        this.tQR.cu(this.tQR.tQp.pFF);
        if (k.bWZ() != null) {
            k.bXd();
        }
    }

    public final String toString() {
        return super.toString() + "|dealWNoteInfo";
    }
}
