package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;

class e$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ e jrE;

    e$1(e eVar, j jVar) {
        this.jrE = eVar;
        this.iZy = jVar;
    }

    public final void onDestroy() {
        a.bD(this.iZy.mAppId, "");
    }
}
