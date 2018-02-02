package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;

public final class a extends com.tencent.mm.ae.a<oj> {
    public a(String str, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new oi();
        aVar.hmk = new oj();
        aVar.hmi = 1386;
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        oi oiVar = (oi) JZ.hmg.hmo;
        oiVar.vXm = str;
        oiVar.vXn = i;
        this.gJQ = JZ;
    }
}
