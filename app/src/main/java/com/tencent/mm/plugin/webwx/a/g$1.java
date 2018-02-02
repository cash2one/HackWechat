package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.g.a.on;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class g$1 implements a {
    final /* synthetic */ g tOt;

    g$1(g gVar) {
        this.tOt = gVar;
    }

    public final void a(d.a aVar) {
        String str = (String) bi.y(n.a(aVar.hmq.vGZ), "sysmsg").get(".sysmsg.pushloginurl.url");
        if (bh.ov(str)) {
            x.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        b onVar = new on();
        onVar.fGv.fGw = str;
        onVar.fGv.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(onVar);
        aVar.hmq.vHd = null;
    }
}
