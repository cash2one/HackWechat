package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.brv;
import com.tencent.mm.protocal.c.brw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class g extends l {
    public int errCode;
    public String fqV;
    private b gJQ;
    private e gJT;

    public g(int i, int i2, String str, alc com_tencent_mm_protocal_c_alc, alb com_tencent_mm_protocal_c_alb) {
        a aVar = new a();
        aVar.hmj = new brv();
        aVar.hmk = new brw();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
        aVar.hmi = 1306;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        brv com_tencent_mm_protocal_c_brv = (brv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_brv.wij = i;
        com_tencent_mm_protocal_c_brv.fCz = i2;
        this.fqV = str;
        com_tencent_mm_protocal_c_brv.wip = com_tencent_mm_protocal_c_alc;
        com_tencent_mm_protocal_c_brv.wio = com_tencent_mm_protocal_c_alb;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            brw com_tencent_mm_protocal_c_brw = (brw) this.gJQ.hmh.hmo;
            x.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + com_tencent_mm_protocal_c_brw.fxK + ",errMsg:" + com_tencent_mm_protocal_c_brw.fxL);
            this.gJT.a(i, com_tencent_mm_protocal_c_brw.fxK, str, this);
            return;
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1306;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
