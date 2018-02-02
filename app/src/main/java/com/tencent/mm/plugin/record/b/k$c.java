package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;

class k$c implements Runnable {
    private g pEX;
    final /* synthetic */ k pFv;

    public k$c(k kVar, g gVar) {
        this.pFv = kVar;
        this.pEX = gVar;
    }

    public final void run() {
        Iterator it = this.pEX.field_dataProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            b fvVar = new fv();
            fvVar.fvq.type = 2;
            fvVar.fvq.fvs = uqVar;
            a.xef.m(fvVar);
            x.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", uqVar.mvG, Integer.valueOf(uqVar.bjS));
            if (!bh.ov(fvVar.fvr.path)) {
                String c = h.c(uqVar, this.pEX.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", fvVar.fvr.path, c);
                if (!fvVar.fvr.path.equals(c)) {
                    k.q(fvVar.fvr.path, c, false);
                }
            }
            if (!bh.ov(fvVar.fvr.fvC)) {
                String f = h.f(uqVar, this.pEX.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", fvVar.fvr.fvC, f);
                if (!fvVar.fvr.fvC.equals(f)) {
                    k.q(fvVar.fvr.fvC, f, false);
                }
            }
        }
        ar.CG().a(new a(this.pEX), 0);
    }
}
