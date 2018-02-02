package com.tencent.mm.booter;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.booter.k.2;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class k$2$1 implements e {
    final /* synthetic */ com.tencent.mm.modelmulti.e gyI;
    final /* synthetic */ 2 gyJ;

    k$2$1(2 2, com.tencent.mm.modelmulti.e eVar) {
        this.gyJ = 2;
        this.gyI = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            za zaVar = (za) this.gyI.hFi.hmh.hmo;
            if (zaVar.result == 0) {
                aky com_tencent_mm_protocal_c_aky = zaVar.wiU;
                akt com_tencent_mm_protocal_c_akt = zaVar.wiW;
                String str2 = com_tencent_mm_protocal_c_aky.title + "," + com_tencent_mm_protocal_c_aky.desc + "," + com_tencent_mm_protocal_c_aky.wrZ + "," + com_tencent_mm_protocal_c_aky.wsa + "," + com_tencent_mm_protocal_c_akt.ned + "," + com_tencent_mm_protocal_c_akt.major + "," + com_tencent_mm_protocal_c_akt.minor;
                ar.Hg();
                String[] split = bh.az((String) c.CU().get(a.xqd, null), "").split(",");
                Boolean valueOf = Boolean.valueOf(false);
                Boolean bool = valueOf;
                for (String equals : split) {
                    if (equals.equals(com_tencent_mm_protocal_c_akt.ned + com_tencent_mm_protocal_c_akt.major + com_tencent_mm_protocal_c_akt.minor)) {
                        bool = Boolean.valueOf(true);
                    }
                }
                if (bool.booleanValue()) {
                    ar.Hg();
                    c.CU().a(a.xqc, "");
                } else {
                    g.pQN.h(12653, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                    g.pQN.h(12653, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                    ar.Hg();
                    c.CU().a(a.xqc, str2);
                }
            } else {
                ar.Hg();
                c.CU().a(a.xqc, "");
            }
        } else {
            ar.Hg();
            c.CU().a(a.xqc, "");
        }
        ar.Hg();
        c.Cu();
        com.tencent.mm.sdk.b.a.xef.m(new di());
        k.a(Boolean.valueOf(false));
        ar.CG().b(1708, this);
    }
}
