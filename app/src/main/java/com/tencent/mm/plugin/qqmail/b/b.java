package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ay.n;
import com.tencent.mm.g.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

final class b extends c<af> {
    b() {
        this.xen = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.QQMail.EventListener", "not bind qq event");
        } else if (afVar.fnY.foa == 0) {
            try {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(17, Integer.valueOf(2));
                int Gd = q.Gd() | 1;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(34, Integer.valueOf(Gd));
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new n("", "", "", "", "", "", "", "", Gd, "", ""));
                w.bku();
                x.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
