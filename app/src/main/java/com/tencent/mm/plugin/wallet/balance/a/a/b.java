package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.aty;

public final class b extends a<aty> {
    public b(int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new atx();
        aVar.hmk = new aty();
        aVar.hmi = 2585;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        ((atx) JZ.hmg.hmo).vXn = i;
        this.gJQ = JZ;
    }
}
