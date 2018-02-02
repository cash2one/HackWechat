package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.List;

class g$4 implements Runnable {
    final /* synthetic */ g qTk;
    final /* synthetic */ int qTl = 0;
    final /* synthetic */ List qTo;
    final /* synthetic */ an qTp;

    g$4(g gVar, List list, int i, an anVar) {
        this.qTk = gVar;
        this.qTo = list;
        this.qTp = anVar;
    }

    public final void run() {
        long Wq = bh.Wq();
        e eVar = new e(this.qTo);
        eVar.hKZ = i.bJ(this.qTo);
        eVar.qQR = this.qTl;
        int i = 0;
        int i2 = 1;
        while (i < this.qTo.size() && i < 4) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) this.qTo.get(i);
            b bvq = ae.bvq();
            String str = com_tencent_mm_protocal_c_aqr.nGJ;
            int i3 = bvq.qSD.containsKey(i.aE(1, str)) ? 1 : bvq.qSD.containsKey(i.aE(5, str)) ? 1 : 0;
            if (i3 != 0) {
                i2 = 0;
            } else if (!(FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.e(com_tencent_mm_protocal_c_aqr)) || FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.l(com_tencent_mm_protocal_c_aqr)) || FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.m(com_tencent_mm_protocal_c_aqr)))) {
                bvq = ae.bvq();
                if (com_tencent_mm_protocal_c_aqr.ktN == 6) {
                    i2 = 5;
                } else {
                    i2 = 1;
                }
                bvq.a(com_tencent_mm_protocal_c_aqr, i2, eVar, this.qTp);
                i2 = 0;
            }
            i++;
        }
        long bA = bh.bA(Wq);
        if (bA > 100) {
            x.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + bA + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.bnD + " " + ae.bvJ() + " " + eVar.hKZ);
        }
        if (bh.bA(g.c(this.qTk)) > 60000) {
            g.pQN.h(11696, new Object[]{Integer.valueOf(1), Long.valueOf(bA), Integer.valueOf(0), Thread.currentThread().getName(), ae.bvJ(), com.tencent.mm.compatible.util.e.bnD});
            g.a(this.qTk, bh.Wq());
        }
        String bJ = i.bJ(this.qTo);
        if (i2 != 0) {
            ae.aNT().post(new 1(this, bJ));
        }
    }
}
