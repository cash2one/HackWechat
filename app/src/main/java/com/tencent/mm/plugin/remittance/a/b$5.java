package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.g.a.mm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class b$5 extends c<mm> {
    final /* synthetic */ b pHb;

    b$5(b bVar) {
        this.pHb = bVar;
        this.xen = mm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mm mmVar = (mm) bVar;
        x.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", new Object[]{Long.valueOf(mmVar.fEr.fqm), mmVar.fEr.fEs});
        if (mmVar.fEr.fEt != null) {
            if (mmVar.fEr.fEt.hcd == 5) {
                com.tencent.mm.sdk.e.c aVar = new a();
                aVar.field_msgId = mmVar.fEr.fqm;
                aVar.field_transferId = mmVar.fEr.fEs;
                b.bnm();
                b.bnn().b(aVar);
            }
            com.tencent.mm.plugin.remittance.b.c Ip = b.bno().Ip(mmVar.fEr.fEs);
            if (Ip != null) {
                Ip.field_receiveStatus = mmVar.fEr.fEt.hcd;
                b.bno().a(Ip);
            } else if (!((h) g.h(h.class)).aZi().dH(mmVar.fEr.fqm).field_talker.equals(q.FS())) {
                Ip = new com.tencent.mm.plugin.remittance.b.c();
                Ip.field_locaMsgId = mmVar.fEr.fqm;
                Ip.field_transferId = mmVar.fEr.fEt.hcg;
                Ip.field_receiveStatus = mmVar.fEr.fEt.hcd;
                Ip.field_isSend = false;
                b.bno().a(Ip);
            }
        }
        return false;
    }
}
