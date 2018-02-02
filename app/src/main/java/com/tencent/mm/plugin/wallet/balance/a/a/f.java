package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.azl;
import com.tencent.mm.protocal.c.azm;

public final class f extends a<azm> {
    public f(String str, String str2, int i, int i2) {
        b.a aVar = new b.a();
        aVar.hmj = new azl();
        aVar.hmk = new azm();
        aVar.hmi = 1283;
        aVar.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        azl com_tencent_mm_protocal_c_azl = (azl) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_azl.wGx = str;
        com_tencent_mm_protocal_c_azl.pLr = str2;
        com_tencent_mm_protocal_c_azl.wFV = i;
        com_tencent_mm_protocal_c_azl.vXn = i2;
        this.gJQ = JZ;
    }
}
