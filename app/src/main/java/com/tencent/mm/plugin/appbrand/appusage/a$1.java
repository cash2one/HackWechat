package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.u;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.a.pf$b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.appbrand.appusage.a.2;
import com.tencent.mm.plugin.appbrand.appusage.h.c.1;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class a$1 extends c<pf> {
    a$1() {
        this.xen = pf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pf pfVar = (pf) bVar;
        pfVar.fHa.fHc = a.aaB();
        if (pfVar.fGZ.fHb) {
            pf$b com_tencent_mm_g_a_pf_b = pfVar.fHa;
            pfVar.fHa.fHd = false;
            com_tencent_mm_g_a_pf_b.fHe = false;
            if (!a.aaD()) {
                switch (2.iIL[h.aaV().ordinal()]) {
                    case 1:
                        pfVar.fHa.fHe = true;
                        break;
                    case 2:
                        pfVar.fHa.fHd = true;
                        break;
                    default:
                        break;
                }
            }
            pfVar.fHa.fHe = true;
            if (pfVar.fHa.fHd || pfVar.fHa.fHe) {
                h.aaX();
            }
            h.c cVar = h.iJw;
            g.aaL();
            if (g.Dh().Cy() && u.KU()) {
                long Wo = bh.Wo();
                long longValue = ((Long) g.Dj().CU().get(a.xrY, Long.valueOf(0))).longValue();
                long longValue2 = ((Long) g.Dj().CU().get(a.xsa, Long.valueOf(Long.MAX_VALUE))).longValue() + ((Long) g.Dj().CU().get(a.xrZ, Long.valueOf(0))).longValue();
                if (longValue2 > 0 && Wo < longValue && Wo >= longValue2) {
                    x.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                    com.tencent.mm.modelgeo.c.OP().b((a$a) com.tencent.mm.plugin.appbrand.q.c.bj(new 1(cVar)), true);
                    g.Dj().CU().a(a.xrZ, Long.valueOf(Wo));
                }
            }
        }
        return true;
    }
}
