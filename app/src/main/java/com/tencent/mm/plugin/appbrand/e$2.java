package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.n.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements a {
    final /* synthetic */ e irf;

    e$2(e eVar) {
        this.irf = eVar;
    }

    public final void YG() {
        this.irf.Yv();
        e eVar = this.irf;
        if (AppBrandPerformanceManager.tT(eVar.mAppId) && eVar.iqF == null) {
            AppBrandPerformanceManager.tQ(eVar.mAppId);
            if (!DebuggerShell.acg()) {
                eVar.iqF = new h(eVar.iqt, eVar.mAppId);
                eVar.iqD.addView(eVar.iqF);
                a.a(eVar.mAppId, eVar.iqF);
                h hVar = eVar.iqF;
                AppBrandPerformanceManager.tU(hVar.mAppId);
                hVar.setVisibility(0);
                hVar.setAlpha(0.0f);
                hVar.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
            }
        }
        e eVar2 = this.irf;
        long currentTimeMillis = System.currentTimeMillis() - eVar2.iqw.startTime;
        boolean z = eVar2.ira;
        int i = eVar2.Yz() ? 775 : 367;
        int i2 = currentTimeMillis <= 2000 ? z ? 8 : 1 : currentTimeMillis <= 3000 ? z ? 9 : 2 : currentTimeMillis <= 4000 ? z ? 10 : 3 : currentTimeMillis <= 5000 ? z ? 11 : 4 : currentTimeMillis <= 6000 ? z ? 12 : 5 : z ? 13 : 6;
        g.pQN.a((long) i, (long) i2, 1, false);
        if (z) {
            g.pQN.a((long) i, 7, 1, false);
        } else {
            g.pQN.a((long) i, 0, 1, false);
        }
        x.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(z)});
        String str = "MicroMsg.AppBrandRuntime";
        String str2 = "onHideSplash: %s, cost: %dms, download : %b";
        Object[] objArr = new Object[3];
        objArr[0] = eVar2.iqw != null ? eVar2.iqw.frn : "";
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = Boolean.valueOf(eVar2.ira);
        x.i(str, str2, objArr);
        long currentTimeMillis2 = System.currentTimeMillis() - eVar2.iqw.startTime;
        eVar2.iqM.o(5, currentTimeMillis2);
        g gVar = eVar2.iqM;
        boolean z2 = eVar2.ira;
        boolean z3 = eVar2.iqw.iNY;
        boolean z4 = eVar2.iqx.iOn;
        String str3 = eVar2.mAppId;
        gVar.aIt = 0;
        gVar.mType = 0;
        if (eVar2.iqx != null) {
            gVar.aIt = eVar2.iqx.iOI.iGL;
            gVar.mType = eVar2.iqx.iOI.iGK + 1;
        }
        gVar.iry = z2 ? 1 : 0;
        gVar.irz = eVar2.Yw();
        gVar.irB = z3;
        gVar.irC = z4;
        StringBuilder stringBuilder = new StringBuilder();
        for (i2 = 0; i2 < gVar.irx.length; i2++) {
            if (gVar.irx[i2] < 0) {
                x.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[]{Integer.valueOf(i2), Long.valueOf(gVar.irx[i2])});
                break;
            }
            stringBuilder.append(gVar.irx[i2]);
            stringBuilder.append(",");
        }
        AppBrandInitConfig appBrandInitConfig = eVar2.iqw;
        if (appBrandInitConfig != null) {
            i2 = appBrandInitConfig.fnv;
        } else {
            i2 = b.tY(str3);
            x.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[]{Integer.valueOf(i2)});
        }
        i2 += 1000;
        x.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[]{str3, stringBuilder.toString(), Boolean.valueOf(z2), Boolean.valueOf(c.akn()), Integer.valueOf(i2)});
        gVar.e(str3, 1, 0, i2);
        gVar.e(str3, 2, 1, i2);
        gVar.e(str3, 3, 2, i2);
        gVar.e(str3, 4, 3, i2);
        gVar.e(str3, 6, 4, i2);
        gVar.e(str3, 7, 5, i2);
        gVar.e(str3, 23, 6, i2);
        gVar.e(str3, 24, 7, i2);
        gVar.e(str3, 25, 8, i2);
        gVar.e(str3, 26, 9, i2);
        gVar.e(str3, 27, 10, i2);
        gVar.e(str3, 28, 11, i2);
        gVar.e(str3, 29, 12, i2);
        AppBrandPerformanceManager.a(eVar2.mAppId, 202, currentTimeMillis2);
        com.tencent.mm.plugin.appbrand.performance.a.bF(eVar2.iqw.startTime);
        com.tencent.mm.plugin.appbrand.performance.a.a(eVar2.mAppId, "startupDone", eVar2.iqw.startTime, System.currentTimeMillis());
        e.a(this.irf);
        this.irf.irb = null;
        MainProcessTask mainProcessTask = this.irf.iqI;
        mainProcessTask.jJF = AppBrandRemoteTaskController.a.jJU;
        AppBrandMainProcessService.a(mainProcessTask);
    }
}
