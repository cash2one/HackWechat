package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.ada;

public final class g extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new acz();
        aVar.hmk = new ada();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.hmi = 1746;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        aLV();
        acz com_tencent_mm_protocal_c_acz = (acz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_acz.mEi = str;
        com_tencent_mm_protocal_c_acz.mEj = str2;
        com_tencent_mm_protocal_c_acz.mEk = str3;
        com_tencent_mm_protocal_c_acz.vEq = m.aLm();
    }

    public final String aMf() {
        return ((ada) this.gJQ.hmh.hmo).wlw;
    }
}
