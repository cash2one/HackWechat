package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class p$8 implements a {
    final /* synthetic */ p hGP;

    p$8(p pVar) {
        this.hGP = pVar;
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[]{bh.cgy()});
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            g.Dm().g(new 1(this), 100);
        }
    }
}
