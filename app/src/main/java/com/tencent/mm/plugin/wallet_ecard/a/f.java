package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public azi sZB;

    public f(String str, int i) {
        a aVar = new a();
        aVar.hmj = new azh();
        aVar.hmk = new azi();
        aVar.hmi = 1988;
        aVar.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        azh com_tencent_mm_protocal_c_azh = (azh) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_azh.vLI = str;
        com_tencent_mm_protocal_c_azh.fCy = i;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[]{str, Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sZB = (azi) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.sZB.kLO), this.sZB.kLP});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1988;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
