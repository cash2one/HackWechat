package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.p;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.ae.a<q> {
    public a(String str, long j, int i, String str2, String str3, String str4) {
        com.tencent.mm.bq.a pVar = new p();
        pVar.vCW = str;
        pVar.vDp = j;
        pVar.scene = i;
        pVar.vCX = str2;
        pVar.vDr = str3;
        pVar.pLr = str4;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = pVar;
        aVar.hmk = new q();
        aVar.hmi = 1344;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[]{pVar.vCW, Long.valueOf(pVar.vDp), Integer.valueOf(pVar.scene), pVar.vCX, pVar.vDr, pVar.pLr});
    }
}
