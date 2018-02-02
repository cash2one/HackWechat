package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.aua;

public final class c extends a<aua> {
    public c(int i) {
        b.a aVar = new b.a();
        aVar.hmj = new atz();
        aVar.hmk = new aua();
        aVar.hmi = 1830;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        ((atz) JZ.hmg.hmo).vXn = i;
        this.gJQ = JZ;
    }
}
