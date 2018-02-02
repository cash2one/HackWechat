package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public String lid;
    public qu pHg;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new qt();
        aVar.hmk = new qu();
        aVar.hmi = 1737;
        aVar.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((qt) this.gJQ.hmg.hmo).vPj = str;
        this.lid = str;
    }

    public final int getType() {
        return 1737;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHg = (qu) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHg.liH), this.pHg.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        qu quVar = (qu) ((b) qVar).hmh.hmo;
        this.zHp = quVar.liH;
        this.zHq = quVar.liI;
    }
}
