package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ad.b;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class a implements com.tencent.mm.plugin.auth.a.a {
    public final void a(f fVar, g gVar, boolean z) {
        if ((gVar.vAZ.wRp & 2) != 0) {
            aq aqVar = gVar.vAZ.wRr;
            if (!z) {
                ar.Hg();
                c.gd(aqVar.vFu);
            }
            String iW = b.iW(q.FS());
            com.tencent.mm.z.aq.hfP.hM(iW);
            com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xxN, iW);
            if (aqVar.vFr != 0) {
                ar.Hg();
                c.Fg().bH(aqVar.vFr + "@qqim", 3);
            }
            b.c((long) aqVar.vFr, 3);
        } else {
            x.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        o.iC(1);
        if (z) {
            com.tencent.mm.sdk.b.b gzVar = new gz();
            gzVar.fxh.fxi = false;
            com.tencent.mm.sdk.b.a.xef.m(gzVar);
            gzVar = new rd();
            gzVar.fIS.fIT = true;
            com.tencent.mm.sdk.b.a.xef.m(gzVar);
            return;
        }
        ar.Dm().F(new 1(this));
    }

    public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        String iW = b.iW(q.FS());
        com.tencent.mm.z.aq.hfP.hM(iW);
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xxN, iW);
        b.c((long) i, 3);
        ar.Hg();
        c.Fg().bH(bVar.vBT.wBf, 2);
        if (i != 0) {
            ar.Hg();
            c.Fg().bH(i + "@qqim", 3);
        }
    }
}
