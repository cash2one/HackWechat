package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.appbrand.appcache.ag.c, a {
    public final void u(Map<String, String> map) {
        if (DebuggerShell.acg()) {
            String str = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            String str2 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            int i = bh.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            int i2 = bh.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            String str3 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            String str4 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            String str5 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            if (i >= 0) {
                if (i != 0) {
                    if (f.Zo() != null && !bh.ov(str4) && !bh.ov(str5)) {
                        if (f.Zo().a(str, i, str4, str5, bh.Wo(), bh.Wo() + 432000)) {
                            d.aJ(str, i);
                        }
                    } else {
                        return;
                    }
                }
                x.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp");
                b qpVar = new qp();
                qpVar.fIi.appId = str;
                qpVar.fIi.userName = str2;
                qpVar.fIi.fIl = i;
                qpVar.fIi.fIk = str3;
                qpVar.fIi.fIm = i2;
                qpVar.fIi.fvR = str4;
                qpVar.fIi.fIn = str5;
                qpVar.fIi.fIo = false;
                qpVar.fIi.scene = 1030;
                com.tencent.mm.sdk.b.a.xef.m(qpVar);
            }
        }
    }

    public final String name() {
        return "ForceOpenAppNotify";
    }

    public final void t(Intent intent) {
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(null, null, stringExtra, intExtra, 0, null, appBrandStatObject);
    }
}
