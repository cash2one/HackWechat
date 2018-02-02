package com.tencent.mm.plugin.j;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ jp kYM;
    final /* synthetic */ jp kYN;
    final /* synthetic */ jp kYO;

    a$1(jp jpVar, jp jpVar2, jp jpVar3) {
        this.kYM = jpVar;
        this.kYN = jpVar2;
        this.kYO = jpVar3;
    }

    public final void run() {
        a aVar = new a();
        long j = -1;
        g.MG();
        if (!(g.MI() == null || this.kYM == null)) {
            g.MG();
            g.MI().a(this.kYM, this.kYN, this.kYO);
            j = aVar.zi();
        }
        x.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", Long.valueOf(aVar.zi()), Long.valueOf(j));
    }
}
