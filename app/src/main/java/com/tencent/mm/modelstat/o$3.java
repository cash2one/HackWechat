package com.tencent.mm.modelstat;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$3 implements a {
    final /* synthetic */ long hSG;
    final /* synthetic */ bbh hSH;

    o$3(long j, bbh com_tencent_mm_protocal_c_bbh) {
        this.hSG = j;
        this.hSH = com_tencent_mm_protocal_c_bbh;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bh.bz(this.hSG)), this.hSH.pQt);
        return 0;
    }
}
