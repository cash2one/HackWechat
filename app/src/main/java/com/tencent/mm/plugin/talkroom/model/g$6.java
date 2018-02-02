package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.R;
import com.tencent.mm.plugin.talkroom.b.c;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.ar;

class g$6 extends a {
    final /* synthetic */ g scg;

    g$6(g gVar) {
        this.scg = gVar;
    }

    public final void j(int i, int i2, boolean z) {
        if (z) {
            g.b(this.scg, 0);
            g.a(this.scg).DM("");
            return;
        }
        g.c(this.scg, i2);
        if (g.i(this.scg) != i) {
            g.b(this.scg, i);
            String bEM = this.scg.bEM();
            if (!g.j(this.scg) && bEM == null) {
                g.k(this.scg);
                int e = g.e(this.scg);
                long f = g.f(this.scg);
                String g = g.g(this.scg);
                g gVar = this.scg;
                g.g(this.scg);
                ar.CG().a(new c(e, f, g, gVar.bEL()), 0);
                f bEF = b.bEF();
                bEF.sbt++;
                bEF = b.bEF();
                bEF.sbu++;
            }
            g.a(this.scg).DM(bEM);
            com.tencent.mm.sdk.platformtools.ar.H(ac.getContext(), R.l.eQS);
        }
    }
}
