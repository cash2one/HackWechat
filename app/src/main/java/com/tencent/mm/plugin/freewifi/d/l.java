package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bhi;

public final class l extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new bhh();
        aVar.hmk = new bhi();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.hmi = 1761;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1761;
    }

    public l(String str, int i, String str2) {
        aLV();
        bhh com_tencent_mm_protocal_c_bhh = (bhh) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhh.appId = str;
        com_tencent_mm_protocal_c_bhh.mIk = i;
        com_tencent_mm_protocal_c_bhh.frP = str2;
    }
}
