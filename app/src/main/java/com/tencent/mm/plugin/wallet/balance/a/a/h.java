package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbp;

public final class h extends a<bbp> {
    public h(int i, String str, String str2, int i2) {
        b.a aVar = new b.a();
        aVar.hmj = new bbo();
        aVar.hmk = new bbp();
        aVar.hmi = 1338;
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        bbo com_tencent_mm_protocal_c_bbo = (bbo) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bbo.wEO = i;
        com_tencent_mm_protocal_c_bbo.vXm = str;
        com_tencent_mm_protocal_c_bbo.wER = str2;
        com_tencent_mm_protocal_c_bbo.vXn = i2;
        this.gJQ = JZ;
    }
}
