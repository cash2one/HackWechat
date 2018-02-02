package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private b gJQ;
    private e gJT;
    public yu pHj;

    public h() {
        a aVar = new a();
        aVar.hmj = new yt();
        aVar.hmk = new yu();
        aVar.hmi = 1399;
        aVar.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1399;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHj = (yu) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHj.liH), this.pHj.liI});
        if (!(this.ljp || this.pHj.liH == 0)) {
            this.ljq = true;
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        yu yuVar = (yu) ((b) qVar).hmh.hmo;
        this.zHp = yuVar.liH;
        this.zHq = yuVar.liI;
    }
}
