package com.tencent.mm.insane_statistic;

import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.aq.r.a;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.c;

public final class b implements a {
    public final void a(long j, au auVar, com.tencent.mm.ae.b bVar, int i, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        a aVar = new a(j, auVar, bVar, z, i);
        c fn = com.tencent.mm.z.c.c.IF().fn("100131");
        if (fn.isValid()) {
            aVar.gLV = t.getInt((String) fn.chI().get("needUploadData"), 1);
        }
        if (!aVar.gLT) {
            if (aVar.gLX || aVar.gLV != 0) {
                aVar.gLW = com_tencent_mm_modelcdntran_keep_SceneResult;
                aVar.gLT = true;
                String str = ((bqt) aVar.gJQ.hmg.hmo).vGY.wJF;
                Object obj = (bh.ov(str) || !str.endsWith("@chatroom")) ? null : 1;
                aVar.gLS = "2," + (obj != null ? 2 : 1) + ",,";
                if (aVar.gLR == null) {
                    aVar.gLR = o.Pw().b(Long.valueOf(aVar.gLP));
                }
                e eVar = aVar.gLR;
                if (eVar != null) {
                    com.tencent.mm.sdk.b.b mpVar = new mp();
                    com.tencent.mm.sdk.b.a.xef.b(aVar.gLY);
                    com.tencent.mm.sdk.b.a.xef.b(aVar.gLZ);
                    aVar.gLU = o.Pw().m(eVar.hzQ, "", "");
                    mpVar.fEA.filePath = aVar.gLU;
                    com.tencent.mm.sdk.b.a.xef.m(mpVar);
                }
            }
        }
    }
}
