package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    public String fqR;
    private b gJQ;
    private e gJT;
    public ys pHi;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new yr();
        aVar.hmk = new ys();
        aVar.hmi = 1542;
        aVar.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((yr) this.gJQ.hmg.hmo).vUZ = str;
        this.fqR = str2;
    }

    public final int getType() {
        return 1542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHi = (ys) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHi.liH), this.pHi.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ys ysVar = (ys) ((b) qVar).hmh.hmo;
        this.zHp = ysVar.liH;
        this.zHq = ysVar.liI;
    }
}
