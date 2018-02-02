package com.tencent.mm.modelstat;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements e {
    final /* synthetic */ c hQj;
    final /* synthetic */ a hQl;
    final /* synthetic */ String hQm;

    c$4(c cVar, a aVar, String str) {
        this.hQj = cVar;
        this.hQl = aVar;
        this.hQm = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1126 && i == 0 && i2 == 0) {
            acd com_tencent_mm_protocal_c_acd = (acd) ((j) kVar).hRB.hmh.hmo;
            if (com_tencent_mm_protocal_c_acd == null) {
                x.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
            } else {
                c.b(this.hQj).post(new 1(this, com_tencent_mm_protocal_c_acd));
            }
        }
    }
}
