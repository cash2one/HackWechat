package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.tc;
import com.tencent.mm.g.a.tc$b;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$6 extends c<tc> {
    final /* synthetic */ b ifC;

    b$6(b bVar) {
        this.ifC = bVar;
        this.xen = tc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i;
        tc tcVar = (tc) bVar;
        String str = tcVar.fLx.fLz;
        tc$b com_tencent_mm_g_a_tc_b = tcVar.fLy;
        d WA = b.WA();
        if (d.ihf.containsKey(str)) {
            i = ((com.tencent.mm.plugin.aa.a.b.c) d.ihf.get(str)).field_status;
        } else {
            com.tencent.mm.plugin.aa.a.b.c oD = WA.oD(str);
            if (oD != null) {
                d.ihf.put(str, oD);
                i = oD.field_status;
            } else {
                i = -1;
            }
        }
        com_tencent_mm_g_a_tc_b.status = i;
        return false;
    }
}
