package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private b gJQ;
    private e gJT;
    public azt pHn;

    public l(String str) {
        a aVar = new a();
        aVar.hmj = new azs();
        aVar.hmk = new azt();
        aVar.hmi = 1579;
        aVar.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((azs) this.gJQ.hmg.hmo).vPj = str;
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", str);
    }

    public final int getType() {
        return 1579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pHn = (azt) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        azt com_tencent_mm_protocal_c_azt = (azt) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_azt.liH;
        this.zHq = com_tencent_mm_protocal_c_azt.liI;
    }
}
