package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.protocal.c.ex;

public final class d extends a<axt> {
    public d(int i, ex exVar, int i2) {
        b.a aVar = new b.a();
        aVar.hmj = new axs();
        aVar.hmk = new axt();
        aVar.hmi = 1324;
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        axs com_tencent_mm_protocal_c_axs = (axs) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_axs.wEO = i;
        if (exVar != null) {
            com_tencent_mm_protocal_c_axs.wEP = 1;
            com_tencent_mm_protocal_c_axs.wEQ = exVar;
        } else {
            com_tencent_mm_protocal_c_axs.wEP = 0;
            com_tencent_mm_protocal_c_axs.wEQ = null;
        }
        com_tencent_mm_protocal_c_axs.vXn = i2;
        this.gJQ = JZ;
    }
}
