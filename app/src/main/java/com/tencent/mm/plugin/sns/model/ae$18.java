package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.by.h;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class ae$18 extends c<ku> {
    final /* synthetic */ ae qWL;

    ae$18(ae aeVar) {
        this.qWL = aeVar;
        this.xen = ku.class.getName().hashCode();
    }

    private static boolean a(ku kuVar) {
        ArrayList arrayList = kuVar.fCd.fxf;
        n bvv = ae.bvv();
        h EV = ae.EV();
        long dz = EV.dz(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                m xo = bvv.xo((int) longValue);
                if (xo != null) {
                    xo.field_localFlag |= 64;
                    x.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[]{Long.valueOf(longValue)});
                    bvv.b((int) longValue, xo);
                }
            }
            return false;
        } finally {
            EV.fS(dz);
        }
    }
}
