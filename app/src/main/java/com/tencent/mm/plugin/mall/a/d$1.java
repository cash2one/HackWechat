package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class d$1 implements a {
    final /* synthetic */ d okX;

    d$1(d dVar) {
        this.okX = dVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + a);
        d.a(this.okX).post(new 1(this, a));
    }
}
