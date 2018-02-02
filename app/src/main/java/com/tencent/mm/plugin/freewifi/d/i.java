package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.aeq;
import com.tencent.mm.protocal.c.aer;

public final class i extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new aeq();
        aVar.hmk = new aer();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.hmi = 1709;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        aLV();
        aeq com_tencent_mm_protocal_c_aeq = (aeq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aeq.fpz = str;
        com_tencent_mm_protocal_c_aeq.mEi = str2;
        com_tencent_mm_protocal_c_aeq.mEj = str3;
        com_tencent_mm_protocal_c_aeq.mEk = str4;
        com_tencent_mm_protocal_c_aeq.frP = str5;
        com_tencent_mm_protocal_c_aeq.vDZ = str6;
    }

    public final String aMg() {
        return ((aer) this.gJQ.hmh.hmo).mFq;
    }

    public final String aMh() {
        return ((aer) this.gJQ.hmh.hmo).mFr;
    }
}
