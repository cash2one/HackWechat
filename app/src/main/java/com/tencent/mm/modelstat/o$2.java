package com.tencent.mm.modelstat;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class o$2 implements a {
    final /* synthetic */ float hLG;
    final /* synthetic */ float hLH;
    final /* synthetic */ int hLJ;
    final /* synthetic */ long hSG;
    final /* synthetic */ bbh hSH;
    final /* synthetic */ String[] hSI;
    final /* synthetic */ long hSJ;

    o$2(long j, bbh com_tencent_mm_protocal_c_bbh, String[] strArr, float f, float f2, int i, long j2) {
        this.hSG = j;
        this.hSH = com_tencent_mm_protocal_c_bbh;
        this.hSI = strArr;
        this.hLG = f;
        this.hLH = f2;
        this.hLJ = i;
        this.hSJ = j2;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bh.bz(this.hSG)), this.hSH.pQt);
        if (!(i == 0 && i2 == 0)) {
            long bz = bh.bz(o.Tb());
            if (bz > 600000 || bz < 0) {
                bz = 0;
            }
            g.pQN.k(11747, this.hSI[0] + "1," + this.hLG + "," + this.hLH + "," + this.hLJ + "," + this.hSJ + "," + (com.tencent.mm.sdk.a.b.foreground ? "1" : String.valueOf(bz)) + "," + this.hSI[1] + "," + this.hSI[2] + "," + this.hSI[3]);
        }
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bh.Wp()));
        return 0;
    }
}
