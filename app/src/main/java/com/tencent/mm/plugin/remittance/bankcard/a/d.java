package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    private b gJQ;
    private e gJT;
    public mh pHf;

    public d(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hmj = new mg();
        aVar.hmk = new mh();
        aVar.hmi = 1349;
        aVar.uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        mg mgVar = (mg) this.gJQ.hmg.hmo;
        mgVar.vUY = str;
        mgVar.vUZ = str2;
        mgVar.nBM = str3;
        mgVar.oZz = str4;
    }

    public final int getType() {
        return 1349;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHf = (mh) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHf.liH), this.pHf.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        mh mhVar = (mh) ((b) qVar).hmh.hmo;
        this.zHp = mhVar.liH;
        this.zHq = mhVar.liI;
    }
}
