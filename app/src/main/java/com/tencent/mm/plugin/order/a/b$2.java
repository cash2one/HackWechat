package com.tencent.mm.plugin.order.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class b$2 implements a {
    final /* synthetic */ b oZS;

    b$2(b bVar) {
        this.oZS = bVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + a);
        b.a(this.oZS).post(new 1(this, a));
    }
}
