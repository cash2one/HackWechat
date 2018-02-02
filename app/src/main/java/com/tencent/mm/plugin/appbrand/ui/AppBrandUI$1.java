package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.e;

class AppBrandUI$1 extends d {
    final /* synthetic */ AppBrandUI jMR;

    AppBrandUI$1(AppBrandUI appBrandUI, Activity activity) {
        this.jMR = appBrandUI;
        super(activity);
    }

    protected final void aaw() {
        e YI = AppBrandUI.a(this.jMR).YI();
        if (YI != null) {
            c.a(YI.mAppId, c.c.iqn);
        }
    }
}
