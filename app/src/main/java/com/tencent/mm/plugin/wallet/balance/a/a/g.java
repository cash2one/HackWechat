package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.protocal.c.azo;

public final class g extends a<azo> {
    private b hNJ;
    private azn syi = null;

    public g() {
        b.a aVar = new b.a();
        aVar.hmj = new azn();
        aVar.hmk = new azo();
        aVar.hmi = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.syi = (azn) this.hNJ.hmg.hmo;
        this.syi.time_stamp = (int) System.currentTimeMillis();
        this.gJQ = aVar.JZ();
    }
}
