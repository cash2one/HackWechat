package com.tencent.mm.plugin.sns.ui.b;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.b.b.19;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.storage.an;

class b$19$1 implements Runnable {
    final /* synthetic */ aqr qSH;
    final /* synthetic */ ak rQa;
    final /* synthetic */ m rQb;
    final /* synthetic */ bnp rQc;
    final /* synthetic */ boolean rQd;
    final /* synthetic */ 19 rQe;

    b$19$1(19 19, aqr com_tencent_mm_protocal_c_aqr, ak akVar, m mVar, bnp com_tencent_mm_protocal_c_bnp, boolean z) {
        this.rQe = 19;
        this.qSH = com_tencent_mm_protocal_c_aqr;
        this.rQa = akVar;
        this.rQb = mVar;
        this.rQc = com_tencent_mm_protocal_c_bnp;
        this.rQd = z;
    }

    public final void run() {
        if (ae.bvs().u(this.qSH)) {
            this.rQa.qvN.aA(null, false);
            g bvs = ae.bvs();
            m mVar = this.rQb;
            aqr com_tencent_mm_protocal_c_aqr = this.qSH;
            a aVar = this.rQa.qvN;
            int hashCode = this.rQe.rPY.activity.hashCode();
            int i = this.rQa.position;
            an ciT = an.ciT();
            ciT.time = this.rQc.pbl;
            bvs.a(mVar, com_tencent_mm_protocal_c_aqr, aVar, hashCode, i, ciT, this.rQd);
            this.rQa.rkR.setVisibility(0);
            this.rQa.rxi.setVisibility(8);
            this.rQa.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.rQe.rPY.activity, i.dAI));
        }
    }
}
