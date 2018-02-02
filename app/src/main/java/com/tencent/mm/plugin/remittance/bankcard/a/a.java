package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private b gJQ;
    private e gJT;
    public dm pHc;
    public String pHd;

    public a(String str, String str2, String str3) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new dl();
        aVar.hmk = new dm();
        aVar.hmi = 1348;
        aVar.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        dl dlVar = (dl) this.gJQ.hmg.hmo;
        dlVar.pHK = str;
        dlVar.vII = str2;
        dlVar.oZz = str3;
        this.pHd = str;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[]{str, str2, str3});
    }

    public final int getType() {
        return 1348;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHc = (dm) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHc.liH), this.pHc.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        dm dmVar = (dm) ((b) qVar).hmh.hmo;
        this.zHp = dmVar.liH;
        this.zHq = dmVar.liI;
    }
}
