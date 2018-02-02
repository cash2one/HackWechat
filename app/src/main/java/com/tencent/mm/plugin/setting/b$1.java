package com.tencent.mm.plugin.setting;

import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class b$1 implements b {
    final /* synthetic */ b qfX;

    b$1(b bVar) {
        this.qfX = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (i == 2) {
            String str = (String) obj;
            ar.Hg();
            af WJ = c.EY().WJ(str);
            if (WJ != null && !a.fZ(WJ.field_type) && WJ.AD() && !WJ.AE()) {
                ar.Dm().g(new 1(this, str), 5000);
            }
        }
    }
}
