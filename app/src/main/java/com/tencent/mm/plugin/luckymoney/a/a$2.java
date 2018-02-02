package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.mm.g.a.th;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g$a;

class a$2 extends c<th> {
    final /* synthetic */ a nYP;

    a$2(a aVar) {
        this.nYP = aVar;
        this.xen = th.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        th thVar = (th) bVar;
        if (!bh.ov(thVar.fLK.fDP)) {
            g$a fT = g$a.fT(thVar.fLK.fDP);
            if (!bh.ov(fT.hcH)) {
                x.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[]{fT.hcH});
                y Nf = o.bLn().Nf(fT.hcH);
                if (Nf == null) {
                    Nf = new y();
                }
                if (bh.ov(Nf.field_mNativeUrl)) {
                    Nf.field_mNativeUrl = fT.hcH;
                    Nf.field_receiveStatus = 0;
                }
                o.bLn().a(Nf);
            }
        }
        return false;
    }
}
