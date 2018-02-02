package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bq.a;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class k implements q<bw> {
    public final /* synthetic */ void e(a aVar) {
        String a = n.a(((bw) aVar).vGX);
        if (s.eV(a)) {
            ar.Hg();
            com.tencent.mm.storage.q hE = c.Fh().hE(a);
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(a);
            if (WO == null || ((int) WO.gJd) <= 0) {
                ak.a.hfL.a(a, null, new 1(this, hE, a));
            } else if (hE.chR()) {
                b jxVar = new jx();
                jxVar.fAY.chatroomName = a;
                jxVar.fAY.fAZ = hE.chQ();
                com.tencent.mm.sdk.b.a.xef.m(jxVar);
            }
        }
    }

    public final /* synthetic */ void f(a aVar) {
        String a = n.a(((bw) aVar).vGX);
        if (!bh.ov(a) && !((h) g.h(h.class)).EY().WQ(a)) {
            ak.a.hfL.Q(a, "");
        }
    }
}
