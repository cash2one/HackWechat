package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import junit.framework.Assert;

public final class af implements c {
    public final void a(Context context, String str, String str2, String str3, int i, String str4) {
        if (!bh.ov(str3)) {
            if (bh.ov(str3) || bh.ov(str2)) {
                x.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.fnp = p.encode(bh.ou(str)) + ":" + str2;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.iOd = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.a(context, null, str3, str4, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
        }
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject) {
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, null, null);
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject, String str4) {
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        switch (appBrandStatObject.scene) {
            case 1020:
            case 1035:
            case 1043:
                appBrandLaunchReferrer.iOd = 5;
                break;
            case 1036:
            case 1069:
                appBrandLaunchReferrer.iOd = 4;
                break;
            case 1055:
                appBrandLaunchReferrer.iOd = 2;
                break;
        }
        appBrandLaunchReferrer.appId = str4;
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, null);
    }

    public final void a(Context context, String str, String str2, boolean z, a aVar) {
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1036;
        appBrandStatObject.fnp = bh.ou(aVar.appId) + ":" + bh.ou(p.encode(aVar.url));
        appBrandStatObject.fIs = z ? 2 : 1;
        if (z) {
            str2 = str;
        }
        appBrandStatObject.fIt = str2;
        LaunchParamsOptional launchParamsOptional = null;
        if (!bh.ov(aVar.hdD)) {
            launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.hjz = str;
            launchParamsOptional.hjA = aVar.hdD;
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.iOd = 4;
        appBrandLaunchReferrer.appId = aVar.appId;
        AppBrandLaunchProxyUI.a(context, aVar.hdx, aVar.hdy, aVar.hdw, aVar.hdE, aVar.hdF, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
    }
}
