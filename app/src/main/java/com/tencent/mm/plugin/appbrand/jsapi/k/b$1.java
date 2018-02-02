package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.b;

class b$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ b jqs;

    b$1(b bVar, j jVar, j jVar2) {
        this.jqs = bVar;
        this.iZy = jVar2;
        super(jVar);
    }

    public final void onDestroy() {
        c.b(this.iZy.mAppId, this);
        this.jqs.bgR.unregisterListener(this);
    }
}
