package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.storage.an;

class b$5 implements Runnable {
    final /* synthetic */ b qSG;
    final /* synthetic */ aqr qSH;
    final /* synthetic */ int qSI;
    final /* synthetic */ e qSJ;
    final /* synthetic */ an qSK;

    b$5(b bVar, aqr com_tencent_mm_protocal_c_aqr, int i, e eVar, an anVar) {
        this.qSG = bVar;
        this.qSH = com_tencent_mm_protocal_c_aqr;
        this.qSI = i;
        this.qSJ = eVar;
        this.qSK = anVar;
    }

    public final void run() {
        au.Kv(this.qSH.nGJ);
        b.a(this.qSG, this.qSH, this.qSI, this.qSJ, this.qSK);
    }
}
