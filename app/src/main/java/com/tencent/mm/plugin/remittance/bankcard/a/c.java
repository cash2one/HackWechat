package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private b gJQ;
    private e gJT;
    public jb pHe;

    public c(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new ja();
        aVar.hmk = new jb();
        aVar.hmi = 1340;
        aVar.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ja jaVar = (ja) this.gJQ.hmg.hmo;
        jaVar.vPj = str;
        jaVar.pLr = str2;
    }

    public final int getType() {
        return 1340;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHe = (jb) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHe.liH), this.pHe.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        jb jbVar = (jb) ((b) qVar).hmh.hmo;
        this.zHp = jbVar.liH;
        this.zHq = jbVar.liI;
    }
}
