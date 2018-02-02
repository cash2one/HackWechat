package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.wi;

public final class h extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new aem();
        aVar.hmk = new aen();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.hmi = 1760;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        aLV();
        aem com_tencent_mm_protocal_c_aem = (aem) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aem.appId = str;
        com_tencent_mm_protocal_c_aem.mIk = i;
        com_tencent_mm_protocal_c_aem.frP = str2;
    }

    public final wi aLZ() {
        aen com_tencent_mm_protocal_c_aen = (aen) this.gJQ.hmh.hmo;
        if (com_tencent_mm_protocal_c_aen != null) {
            return com_tencent_mm_protocal_c_aen.vEk;
        }
        return null;
    }
}
