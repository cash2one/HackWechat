package com.tencent.mm.booter;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.k.g;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

class k$2 implements a {
    k$2() {
    }

    public final boolean uF() {
        try {
            ar.Hg();
            Boolean valueOf = Boolean.valueOf(bh.a((Boolean) c.CU().get(w.a.xqg, null), false));
            List<String> zN = g.zZ().zN();
            if (zN != null) {
                for (String str : zN) {
                    x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", new Object[]{str});
                    b djVar = new dj();
                    djVar.frU.frW = str;
                    djVar.frU.frT = false;
                    if (!valueOf.booleanValue()) {
                        com.tencent.mm.sdk.b.a.xef.m(djVar);
                    }
                }
                akv com_tencent_mm_protocal_c_akv = new akv();
                com_tencent_mm_protocal_c_akv.latitude = (double) k.wQ();
                com_tencent_mm_protocal_c_akv.longitude = (double) k.wR();
                ar.Hg();
                long a = bh.a((Long) c.CU().get(w.a.xpX, null), 0);
                if (k.wS().size() <= 0 || k.wT().booleanValue() || k.wU().size() <= 0) {
                    ar.Hg();
                    c.CU().a(w.a.xqc, "");
                } else {
                    k.a(Boolean.valueOf(true));
                    k eVar = new e(k.wU(), a, com_tencent_mm_protocal_c_akv);
                    x.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.wU().size() + ",info:" + k.wU().toString());
                    ar.CG().a(1708, new 1(this, eVar));
                    ar.CG().a(eVar, 0);
                }
                k.wS().clear();
                k.wU().clear();
                com.tencent.mm.sdk.b.a.xef.c(k.wV());
            }
        } catch (Exception e) {
            x.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
        }
        return false;
    }
}
