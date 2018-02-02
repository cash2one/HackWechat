package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.n;

public final class f extends a {
    public f() {
        super(m.jAL - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig.iOI.iGK == 1) {
            CharSequence string;
            if (appBrandSysConfig.iOj) {
                string = context.getString(j.iAo);
            } else {
                string = context.getString(j.iAv);
            }
            nVar.f(m.jAL - 1, string);
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        if ((!pVar.irP.iqx.iOj ? 1 : 0) != 0) {
            AppBrandPerformanceManager.tR(str);
            Toast.makeText(context, j.iAw, 0).show();
            return;
        }
        AppBrandPerformanceManager.tS(str);
        Toast.makeText(context, j.iAp, 0).show();
    }
}
