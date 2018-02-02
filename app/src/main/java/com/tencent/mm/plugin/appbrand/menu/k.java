package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;

public final class k extends a {
    public k() {
        super(m.jAO - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        g.h(d.class);
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (AppBrandStickyBannerLogic.a.aM(appBrandSysConfig.appId, appBrandSysConfig.iOI.iGK)) {
            AppBrandStickyBannerLogic.a.uw(appBrandSysConfig.appId);
            com.tencent.mm.ui.snackbar.a.a(context, ((Activity) context).findViewById(16908290), context.getString(j.iyq));
        } else {
            c.a(str, c$c.HANG);
            AppBrandStickyBannerLogic.a.a(context, appBrandSysConfig.appId, appBrandSysConfig.iOI.iGK, appBrandSysConfig.frn, appBrandSysConfig.iOg);
        }
        com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 13, "", bh.Wo(), 1, 0);
    }
}
