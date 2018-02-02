package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c qfc;
    final /* synthetic */ int qfd;

    c$2(c cVar, int i) {
        this.qfc = cVar;
        this.qfd = i;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", new Object[]{Integer.valueOf(this.qfd)});
            d.pPH.a(416, 1, 1, false);
        } else {
            x.d("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", new Object[]{Integer.valueOf(this.qfd), Integer.valueOf(i), Integer.valueOf(i2), str});
            d.pPH.a(416, 2, 1, false);
        }
        return 0;
    }
}
