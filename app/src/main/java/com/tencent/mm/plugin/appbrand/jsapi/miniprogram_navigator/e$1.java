package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class e$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ String gBF;
    final /* synthetic */ int iJO;
    final /* synthetic */ j iZy;
    final /* synthetic */ b joo;
    final /* synthetic */ AppBrandLaunchReferrer jop;
    final /* synthetic */ AppBrandStatObject joq;

    e$1(b bVar, String str, AppBrandLaunchReferrer appBrandLaunchReferrer, j jVar, String str2, int i, AppBrandStatObject appBrandStatObject) {
        this.joo = bVar;
        this.gBF = str;
        this.jop = appBrandLaunchReferrer;
        this.iZy = jVar;
        this.fgU = str2;
        this.iJO = i;
        this.joq = appBrandStatObject;
    }

    public final void a(AppBrandInitConfig appBrandInitConfig) {
        if (appBrandInitConfig != null) {
            if (this.joo != null) {
                this.joo.cO(true);
            }
            appBrandInitConfig.startTime = System.currentTimeMillis();
            appBrandInitConfig.iNW = com.tencent.mm.plugin.appbrand.appcache.a.px(this.gBF);
            appBrandInitConfig.iNZ.a(this.jop);
            c.a(this.iZy.mAppId, c$c.LAUNCH_MINI_PROGRAM);
            if (appBrandInitConfig.Yz()) {
                g.jzg.a(this.iZy.getContext(), null, this.fgU, this.gBF, this.iJO, -1, this.joq, this.jop, null);
                return;
            }
            e eVar = this.iZy.irP;
            eVar.iqu.a(eVar, appBrandInitConfig, this.joq);
        } else if (this.joo != null) {
            this.joo.cO(false);
        }
    }
}
