package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private b gJQ;
    private e gJT;
    public String pHd;
    public qw pHh;

    public f(String str) {
        a aVar = new a();
        aVar.hmj = new qv();
        aVar.hmk = new qw();
        aVar.hmi = 1395;
        aVar.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((qv) this.gJQ.hmg.hmo).pHK = str;
        this.pHd = str;
    }

    public final int getType() {
        return 1395;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHh = (qw) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHh.liH), this.pHh.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        qw qwVar = (qw) ((b) qVar).hmh.hmo;
        this.zHp = qwVar.liH;
        this.zHq = qwVar.liI;
    }
}
