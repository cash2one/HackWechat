package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i.a.b.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;

class b$a$1 extends c<lu> {
    final /* synthetic */ a vgJ;

    b$a$1(a aVar) {
        this.vgJ = aVar;
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (g.Dh().Cy()) {
            g.Dh();
            if (!com.tencent.mm.kernel.a.Cs()) {
                long Wo = bh.Wo();
                long a = bh.a((Long) g.Dj().CU().get(w.a.xpT, null), 0);
                if (a != 0 && a < Wo) {
                    p.aqV();
                }
            }
        }
        return false;
    }
}
