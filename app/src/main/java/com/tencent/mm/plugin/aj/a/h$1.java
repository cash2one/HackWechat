package com.tencent.mm.plugin.aj.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.to;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aj.a.h.a;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements e {
    h$1() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof e) {
            g.CG().b(1948, h.bDt());
            b toVar = new to();
            if (i == 0 && i2 == 0) {
                e eVar = (e) kVar;
                bzt com_tencent_mm_protocal_c_bzt = eVar.tkk;
                bzs com_tencent_mm_protocal_c_bzs = eVar.tkj;
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[]{com_tencent_mm_protocal_c_bzt.vOe});
                if (h.eG(com_tencent_mm_protocal_c_bzs.lOo, com_tencent_mm_protocal_c_bzt.vOe) == a.tkr) {
                    toVar.fMf.result = 0;
                } else {
                    toVar.fMf.result = -1;
                }
            } else {
                toVar.fMf.result = -1;
            }
            com.tencent.mm.sdk.b.a.xef.m(toVar);
        }
    }
}
