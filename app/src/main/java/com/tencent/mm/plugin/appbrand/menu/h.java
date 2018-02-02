package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.ui.base.n;
import java.util.HashMap;
import java.util.Map;

public final class h extends a {
    public h() {
        super(m.jAH - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig == null || appBrandSysConfig.iOI.iGK != 0 || (appBrandSysConfig.abX() & 32) <= 0) {
            nVar.f(this.jAX, context.getString(j.iBn));
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(context, "pref_appbrand_" + appBrandSysConfig.uin, 4);
        if (appBrandSysConfig.iOI.iGK == 1 && !sharedPreferences.contains("has_share_dev_tips")) {
            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
            com.tencent.mm.ui.base.h.a(context, j.iza, j.dGO, false, new 1(this, pVar, str, lVar));
        } else if (appBrandSysConfig.iOI.iGK != 2 || sharedPreferences.contains("has_share_beta_tips")) {
            a(pVar, lVar);
        } else {
            sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
            com.tencent.mm.ui.base.h.a(context, j.iyZ, j.dGO, false, new 2(this, pVar, str, lVar));
        }
    }

    static void a(p pVar, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        a aVar = new a();
        Map hashMap = new HashMap();
        hashMap.put("title", appBrandSysConfig.frn);
        hashMap.put("desc", "");
        hashMap.put("path", pVar.aeO());
        String str = "webViewUrl";
        com.tencent.mm.plugin.appbrand.jsapi.n.a ajb = pVar.ajb();
        hashMap.put(str, ajb != null ? ajb.juE.getUrl() : null);
        hashMap.put("imgUrl", appBrandSysConfig.iOg);
        hashMap.put("mode", lVar.iTl.hA("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(lVar.iTl.hA("enable_share_dynamic")));
        lVar.iTl.u("user_clicked_share_btn", true);
        aVar.a(pVar).v(hashMap).afs();
    }
}
