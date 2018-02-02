package com.tencent.mm.aq;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class o$1 extends c<oq> {
    final /* synthetic */ o hCJ;

    o$1(o oVar) {
        this.hCJ = oVar;
        this.xen = oq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cf cfVar = ((oq) bVar).fGH.fnB;
        i Pu = o.Pu();
        e bi = o.Pw().bi(cfVar.field_msgId);
        bi.hJ(0);
        o.Pw().a(Long.valueOf(bi.hzP), bi);
        int i = bi.Pe() ? 1 : 0;
        String m = o.Pw().m(bi.hzQ, "", "");
        if (m == null || m.equals("") || !e.bO(m)) {
            x.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
        } else {
            ag.y(new i$6(Pu, bi, i));
        }
        return false;
    }
}
