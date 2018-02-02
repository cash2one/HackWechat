package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.a.td;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class o$5 extends c<td> {
    final /* synthetic */ o sPi;

    o$5(o oVar) {
        this.sPi = oVar;
        this.xen = td.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        y yVar;
        td tdVar = (td) bVar;
        g bLn = o.bLn();
        String str = tdVar.fLA.fLC;
        if (!bh.ov(str)) {
            if (g.ihf.containsKey(str)) {
                yVar = (y) g.ihf.get(str);
            } else {
                yVar = bLn.Nf(str);
                if (yVar != null) {
                    g.ihf.put(str, yVar);
                }
            }
            if (yVar != null) {
                tdVar.fLB.fLD = yVar.field_hbStatus;
                tdVar.fLB.fLE = yVar.field_receiveStatus;
            }
            return false;
        }
        yVar = null;
        if (yVar != null) {
            tdVar.fLB.fLD = yVar.field_hbStatus;
            tdVar.fLB.fLE = yVar.field_receiveStatus;
        }
        return false;
    }
}
