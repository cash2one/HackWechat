package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayx;

public final class e extends a<ayx> {
    public e(String str, int i, int i2) {
        b.a aVar = new b.a();
        aVar.hmj = new ayw();
        aVar.hmk = new ayx();
        aVar.hmi = 1276;
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        ayw com_tencent_mm_protocal_c_ayw = (ayw) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_ayw.wFU = str;
        com_tencent_mm_protocal_c_ayw.wFV = i;
        com_tencent_mm_protocal_c_ayw.vXn = i2;
        this.gJQ = JZ;
    }
}
