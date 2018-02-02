package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class b$6 extends c<te> {
    final /* synthetic */ b pHb;

    b$6(b bVar) {
        this.pHb = bVar;
        this.xen = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.plugin.remittance.b.c Ip;
        te teVar = (te) bVar;
        d bno = b.bno();
        String str = teVar.fLF.fEs;
        if (bh.ov(str) || !d.ihf.containsKey(str)) {
            Ip = bno.Ip(str);
            if (Ip != null) {
                d.ihf.put(str, Ip);
            } else {
                Ip = null;
            }
        } else {
            Ip = (com.tencent.mm.plugin.remittance.b.c) d.ihf.get(str);
        }
        if (Ip != null) {
            teVar.fLG.status = Ip.field_receiveStatus;
            teVar.fLG.fLH = Ip.field_isSend;
        } else {
            teVar.fLG.status = -2;
            teVar.fLG.fLH = false;
        }
        return false;
    }
}
