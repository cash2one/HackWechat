package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.d$a;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.sdk.platformtools.x;

class e$17 implements d$a {
    final /* synthetic */ e irf;

    e$17(e eVar) {
        this.irf = eVar;
    }

    public final void a(b bVar, boolean z) {
        x.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime.onOrientationChanged");
        if (!z) {
            String str = "MicroMsg.AppBrandRuntime";
            String str2 = "OnOrientationChanged failure  ret:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = bVar == null ? "null" : bVar.name();
            x.f(str, str2, objArr);
        }
        this.irf.iqY = true;
        this.irf.YC();
    }
}
