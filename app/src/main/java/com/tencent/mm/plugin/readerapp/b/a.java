package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.ay.g;
import com.tencent.mm.ay.n;
import com.tencent.mm.g.a.af;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

final class a extends c<af> {
    a() {
        this.xen = af.class.getName().hashCode();
    }

    private boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        } else if (afVar.fnY.foa == 0) {
            try {
                int Gd = q.Gd() | 262144;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(34, Integer.valueOf(Gd));
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_axg = new axg();
                com_tencent_mm_protocal_c_axg.vFu = 262144;
                com_tencent_mm_protocal_c_axg.wEy = 1;
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(39, com_tencent_mm_protocal_c_axg));
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new n("", "", "", "", "", "", "", "", Gd, "", ""));
                g.b(new 1(this));
                int FY = q.FY() & -33;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(40, Integer.valueOf(FY));
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new g(21, 2));
                x.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
