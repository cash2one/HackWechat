package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends b {
    public int asN;
    private b gJQ;
    private e gJT;
    public azx pHk;

    public i(int i, int i2) {
        a aVar = new a();
        aVar.hmj = new azw();
        aVar.hmk = new azx();
        aVar.hmi = 1511;
        aVar.uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        azw com_tencent_mm_protocal_c_azw = (azw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_azw.asN = i;
        com_tencent_mm_protocal_c_azw.offset = i2;
        this.asN = i;
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int getType() {
        return 1511;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHk = (azx) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHk.liH), this.pHk.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        azx com_tencent_mm_protocal_c_azx = (azx) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_azx.liH;
        this.zHq = com_tencent_mm_protocal_c_azx.liI;
    }
}
