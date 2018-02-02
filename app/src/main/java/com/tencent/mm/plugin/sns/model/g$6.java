package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.g.b;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.x;

class g$6 implements Runnable {
    final /* synthetic */ aqr qSH;
    final /* synthetic */ g qTk;
    final /* synthetic */ int qTl;
    final /* synthetic */ String qTr;
    final /* synthetic */ String qTs;

    g$6(g gVar, int i, aqr com_tencent_mm_protocal_c_aqr, String str, String str2) {
        this.qTk = gVar;
        this.qTl = i;
        this.qSH = com_tencent_mm_protocal_c_aqr;
        this.qTr = str;
        this.qTs = str2;
    }

    public final void run() {
        while (g.e(this.qTk).size() >= 60) {
            this.qTk.qTi.remove(((b) g.e(this.qTk).removeFirst()).aAM);
        }
        x.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + g.e(this.qTk).size());
        b bVar = new b(this.qTk, i.aD(this.qTl, this.qSH.nGJ), this.qTr + this.qTs, this.qTr, this.qSH, this.qTl);
        if (g.f(this.qTk).bt(bVar.aAM)) {
            this.qTk.qTi.remove(bVar.aAM);
        } else {
            g.e(this.qTk).add(bVar);
        }
        g.g(this.qTk);
    }
}
