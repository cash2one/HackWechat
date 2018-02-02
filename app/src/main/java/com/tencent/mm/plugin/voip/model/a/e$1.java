package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.buj;

class e$1 implements e {
    final /* synthetic */ e snN;

    e$1(e eVar) {
        this.snN = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.es("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0 && kVar != null) {
            buj com_tencent_mm_protocal_c_buj = (buj) this.snN.bHN();
            if (com_tencent_mm_protocal_c_buj.wJr.vJU == 0 && !d.bGj().smS.bHA()) {
                d.bGj().a(com_tencent_mm_protocal_c_buj);
            }
        }
    }
}
