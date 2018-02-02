package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.u.b;

class i$1 implements e {
    final /* synthetic */ b jeN;
    final /* synthetic */ p jfB;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.compat.a.b jmc;
    final /* synthetic */ i jmd;

    i$1(i iVar, p pVar, com.tencent.mm.plugin.appbrand.compat.a.b bVar, b bVar2) {
        this.jmd = iVar;
        this.jfB = pVar;
        this.jmc = bVar;
        this.jeN = bVar2;
    }

    public final void onDestroy() {
        this.jfB.b(this);
        ag.y(new 1(this));
        this.jeN.recycle();
    }
}
