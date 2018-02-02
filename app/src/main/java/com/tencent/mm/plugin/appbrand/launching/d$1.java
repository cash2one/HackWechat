package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.support.v4.e.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a;
import com.tencent.mm.plugin.appbrand.launching.d.2;
import com.tencent.mm.plugin.appbrand.launching.d.3;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class d$1 implements Runnable {
    final /* synthetic */ HandlerThread jxD;
    final /* synthetic */ d jxE;

    d$1(d dVar, HandlerThread handlerThread) {
        this.jxE = dVar;
        this.jxD = handlerThread;
    }

    public final void run() {
        try {
            h hVar;
            d dVar = this.jxE;
            d dVar2 = this.jxE;
            AppBrandSysConfig qO = q.qO(dVar2.appId);
            if (qO == null) {
                y.ta(c.getMMString(j.iAU, new Object[]{""}));
            }
            if (qO == null) {
                x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "get null config!!!");
                hVar = d.jxC;
            } else {
                com.tencent.mm.plugin.appbrand.p.h hVar2 = new com.tencent.mm.plugin.appbrand.p.h();
                String str = qO.appId;
                String str2 = qO.fnl;
                Object 2 = new 2(dVar2, qO.appId, dVar2.iKd, dVar2.iNW, dVar2.jxz, f.Zh().f(str, new String[]{"versionInfo"}).acb());
                Future futureTask = new FutureTask(2);
                e.post(futureTask, 2.getTag());
                u aib = new ab(str, dVar2.iKd, dVar2.fIs, dVar2.jxz, dVar2.iNW, dVar2.iNZ, dVar2.jxA, dVar2.jxB).aib();
                if (aib == null) {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null launchInfo", new Object[]{qO.fnl});
                    2 = null;
                } else {
                    a aVar = AppBrandLaunchErrorAction.CREATOR;
                    AppBrandLaunchErrorAction a = a.a(str, dVar2.iKd, aib);
                    if (a != null) {
                        hVar2.jRK = a;
                        b.aN(str, dVar2.iKd);
                        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, launch ban code %d", new Object[]{qO.fnl, Integer.valueOf(aib.field_launchAction.vEe)});
                        2 = null;
                    } else if (aib.field_jsapiInfo == null || aib.field_jsapiInfo.vVV == null) {
                        x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null jsapi_info", new Object[]{qO.fnl});
                        2 = null;
                    } else {
                        boolean z = aib.field_actionsheetInfo != null && aib.field_actionsheetInfo.vFT;
                        qO.iOz = z;
                        qO.iOm = new AppRuntimeApiPermissionBundle(aib.field_jsapiInfo);
                        qO.iOn = aib.jxH;
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) futureTask.get();
                        if (wxaPkgWrappingInfo == null) {
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig null app pkg, username %s appId %s", new Object[]{qO.fnl, qO.appId});
                            2 = null;
                        } else {
                            qO.iOI.a(wxaPkgWrappingInfo);
                            if (qO.iOI.iGK != 0) {
                                qO.iOI.iGL = 0;
                            }
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, app pkg %s", new Object[]{qO.fnl, qO.appId, qO.iOI});
                            qO.iOJ = AppBrandGlobalSystemConfig.abS();
                            g.h(d.class);
                            qO.iOk = !g.Dj().CU().getBoolean(w.a.xsf, false);
                            g.Dj().CU().a(w.a.xsf, Boolean.valueOf(true));
                            e.post(new 3(dVar2, str2), "AppLaunchPrepareProcess#ExtraWorks");
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig ok username %s, appId %s", new Object[]{qO.fnl, qO.appId});
                            2 = 1;
                        }
                    }
                }
                if (2 == null) {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig, false, username %s, appId %s", new Object[]{qO.fnl, qO.appId});
                    hVar = h.d(null, hVar2.jRK);
                } else {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "prepare ok, just go weapp, username %s, appId %s", new Object[]{qO.fnl, qO.appId});
                    hVar = h.d(qO, null);
                }
            }
            d.a(dVar, hVar);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess", e, "call() exp ", new Object[0]);
            y.kP(j.iAd);
            d.a(this.jxE, d.ahP());
        }
        this.jxD.quit();
    }
}
