package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.e.b;
import com.tencent.mm.plugin.appbrand.page.p.g;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements g {
    final /* synthetic */ long gyu;
    final /* synthetic */ e jDb;
    final /* synthetic */ b jDc;
    final /* synthetic */ p jeh;

    e$3(e eVar, p pVar, b bVar, long j) {
        this.jDb = eVar;
        this.jeh = pVar;
        this.jDc = bVar;
        this.gyu = j;
    }

    public final void onReady() {
        this.jeh.b((g) this);
        this.jDc.run();
        long currentTimeMillis = System.currentTimeMillis() - this.gyu;
        x.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
    }
}
