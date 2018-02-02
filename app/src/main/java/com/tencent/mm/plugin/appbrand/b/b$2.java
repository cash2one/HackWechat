package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.e;

class b$2 extends c {
    final /* synthetic */ b iGY;

    b$2(b bVar, e eVar) {
        this.iGY = bVar;
        super(eVar);
    }

    final void aar() {
        b.a(this.iGY);
    }

    final void b(a aVar) {
        b bVar = this.iGY;
        synchronized (bVar.iGW) {
        }
        for (b$a com_tencent_mm_plugin_appbrand_b_b_a : (b$a[]) bVar.iGW.keySet().toArray(new b$a[bVar.iGW.size()])) {
            String str = bVar.irP.mAppId;
            com_tencent_mm_plugin_appbrand_b_b_a.a(aVar);
        }
    }
}
