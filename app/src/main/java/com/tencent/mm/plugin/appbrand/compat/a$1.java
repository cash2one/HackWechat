package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.aih;

class a$1 implements a {
    final /* synthetic */ com.tencent.mm.plugin.appbrand.compat.a.a.a iLX;
    final /* synthetic */ a iLY;

    a$1(a aVar, com.tencent.mm.plugin.appbrand.compat.a.a.a aVar2) {
        this.iLY = aVar;
        this.iLX = aVar2;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        boolean z = true;
        if (kVar.getType() == 1926) {
            boolean z2;
            if (i == 0 && i2 == 0) {
                aih com_tencent_mm_protocal_c_aih = (aih) bVar.hmh.hmo;
                z2 = com_tencent_mm_protocal_c_aih != null && com_tencent_mm_protocal_c_aih.wpF;
            } else {
                z2 = false;
                z = false;
            }
            if (this.iLX != null) {
                this.iLX.m(z, z2);
            }
        }
        return 0;
    }
}
