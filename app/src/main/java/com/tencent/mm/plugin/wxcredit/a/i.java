package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcb;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class i extends l {
    private b gJQ;
    private e gJT;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bcb();
        aVar.hmk = new bcc();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        aVar.hmi = 600;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bcb com_tencent_mm_protocal_c_bcb = (bcb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bcb.wIp = str;
        com_tencent_mm_protocal_c_bcb.wIo = bh.getInt(str2, 0);
        com_tencent_mm_protocal_c_bcb.vQS = com.tencent.mm.plugin.wallet_core.model.i.bLf();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 600;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
