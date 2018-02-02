package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class k extends b {
    private b gJQ;
    private e gJT;
    public ava pHm;

    public k() {
        a aVar = new a();
        aVar.hmj = new auz();
        aVar.hmk = new ava();
        aVar.hmi = 1280;
        aVar.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1280;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHm = (ava) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHm.liH), this.pHm.liI});
        if (!(this.ljp || this.ljq)) {
            x.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[]{Integer.valueOf(this.pHm.wCM), Integer.valueOf(this.pHm.wCN)});
            if (this.pHm.wCM >= 0) {
                g.Dj().CU().a(w.a.xxk, Integer.valueOf(this.pHm.wCM));
            }
            if (this.pHm.wCN > 0) {
                g.Dj().CU().a(w.a.xxl, Integer.valueOf(this.pHm.wCN));
            }
            if (!bh.ov(this.pHm.wCO)) {
                g.Dj().CU().a(w.a.xxm, this.pHm.wCO);
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ava com_tencent_mm_protocal_c_ava = (ava) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_ava.liH;
        this.zHq = com_tencent_mm_protocal_c_ava.liI;
    }
}
