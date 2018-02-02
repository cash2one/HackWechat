package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;

class b$3 implements a {
    final /* synthetic */ b pHb;

    b$3(b bVar) {
        this.pHb = bVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            int i;
            c fn = com.tencent.mm.z.c.c.IF().fn("100324");
            if (fn.isValid() && "1".equals(fn.chI().get("open"))) {
                i = 1;
            } else {
                i = 0;
            }
            t CU = g.Dj().CU();
            CU.a(w.a.xxn, Integer.valueOf(i));
            x.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(((Integer) CU.get(w.a.xxo, Integer.valueOf(0))).intValue())});
            if (((Integer) CU.get(w.a.xxo, Integer.valueOf(0))).intValue() == 0) {
                com.tencent.mm.s.c.Bq().b(w.a.xxi, true);
                CU.a(w.a.xxo, Integer.valueOf(1));
                g.Dj().CU().a(w.a.xxj, Boolean.valueOf(false));
            }
        }
    }
}
