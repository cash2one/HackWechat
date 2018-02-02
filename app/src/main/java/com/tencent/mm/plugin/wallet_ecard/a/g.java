package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends com.tencent.mm.wallet_core.c.g {
    private b gJQ;
    private e gJT;
    public azk sZC;

    public g() {
        a aVar = new a();
        aVar.hmj = new azj();
        aVar.hmk = new azk();
        aVar.hmi = 2931;
        aVar.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((azj) this.gJQ.hmg.hmo).wGq = 1;
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.sZC = (azk) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.sZC.kLO), this.sZC.kLP});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        azk com_tencent_mm_protocal_c_azk = (azk) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_azk.kLO;
        this.zHq = com_tencent_mm_protocal_c_azk.kLP;
    }

    public final int getType() {
        return 2931;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
