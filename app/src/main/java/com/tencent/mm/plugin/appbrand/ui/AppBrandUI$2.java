package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.d.a;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandUI$2 implements a {
    final /* synthetic */ AppBrandUI jMR;

    AppBrandUI$2(AppBrandUI appBrandUI) {
        this.jMR = appBrandUI;
    }

    public final void a(b bVar, boolean z) {
        x.i("MicroMsg.AppBrandUI", "onOrientationChanged");
        if (!z) {
            String str;
            String str2 = "MicroMsg.AppBrandUI";
            String str3 = "OnOrientationChanged failure  ret:[%s]";
            Object[] objArr = new Object[1];
            if (bVar == null) {
                str = "null";
            } else {
                str = bVar.name();
            }
            objArr[0] = str;
            x.e(str2, str3, objArr);
        }
    }
}
