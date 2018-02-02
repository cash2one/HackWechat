package com.tencent.mm.plugin.offline;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class k$4 implements a {
    final /* synthetic */ k oWh;

    k$4(k kVar) {
        this.oWh = kVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + a);
        k.a(this.oWh).post(new 1(this, a, aVar));
    }
}
