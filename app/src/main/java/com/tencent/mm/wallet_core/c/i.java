package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l {
    private b gJQ;
    private e gJT;

    public i(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public i(String str, String str2, String str3, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hmj = new awk();
        aVar.hmk = new awl();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.hmi = 421;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awk com_tencent_mm_protocal_c_awk = (awk) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_awk.wEb = str;
        com_tencent_mm_protocal_c_awk.vQS = com.tencent.mm.plugin.wallet_core.model.i.bLf();
        com_tencent_mm_protocal_c_awk.wEc = str3;
        if (!bh.ov(str2)) {
            com_tencent_mm_protocal_c_awk.wEd = new com.tencent.mm.bq.b(str2.getBytes());
        }
        if (i >= 0) {
            com_tencent_mm_protocal_c_awk.vQL = i;
        }
        if (i2 >= 0) {
            com_tencent_mm_protocal_c_awk.vDY = i2;
        }
        if (i3 >= 0) {
            com_tencent_mm_protocal_c_awk.wEe = i3;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 421;
    }
}
