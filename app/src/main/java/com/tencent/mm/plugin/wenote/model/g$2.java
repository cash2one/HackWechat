package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

class g$2 implements Runnable {
    final /* synthetic */ g tQR;

    g$2(g gVar) {
        this.tQR = gVar;
    }

    public final void run() {
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
