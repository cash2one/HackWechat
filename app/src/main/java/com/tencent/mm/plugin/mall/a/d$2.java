package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class d$2 implements a {
    final /* synthetic */ d okX;

    d$2(d dVar) {
        this.okX = dVar;
    }

    public final void a(d.a aVar) {
        x.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[]{n.a(aVar.hmq.vGZ)});
        d.a(this.okX).post(new 1(this, r0));
    }
}
