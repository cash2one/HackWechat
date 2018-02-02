package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    private b gJQ;
    private e gJT;
    public bac pHo;

    public m() {
        a aVar = new a();
        aVar.hmj = new bab();
        aVar.hmk = new bac();
        aVar.hmi = 1378;
        aVar.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1378;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pHo = (bac) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pHo.liH), this.pHo.liI);
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bac com_tencent_mm_protocal_c_bac = (bac) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_bac.liH;
        this.zHq = com_tencent_mm_protocal_c_bac.liI;
    }
}
