package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$LaunchPreconditionTask.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.2;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import junit.framework.Assert;

class JsApiLaunchMiniProgram$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ String gBF;
    final /* synthetic */ int gOK;
    final /* synthetic */ int iJO;
    final /* synthetic */ j iZy;
    final /* synthetic */ String joa;
    final /* synthetic */ JsApiLaunchMiniProgram job;

    JsApiLaunchMiniProgram$1(JsApiLaunchMiniProgram jsApiLaunchMiniProgram, j jVar, String str, int i, String str2, String str3, int i2) {
        this.job = jsApiLaunchMiniProgram;
        this.iZy = jVar;
        this.fgU = str;
        this.iJO = i;
        this.gBF = str2;
        this.joa = str3;
        this.gOK = i2;
    }

    public final void run() {
        e eVar = this.job;
        j jVar = this.iZy;
        String str = this.fgU;
        int i = this.iJO;
        String str2 = this.gBF;
        String str3 = this.joa;
        int i2 = this.gOK;
        MainProcessTask jsApiLaunchMiniProgram$LaunchPreconditionTask = new JsApiLaunchMiniProgram$LaunchPreconditionTask();
        jsApiLaunchMiniProgram$LaunchPreconditionTask.joe = str;
        jsApiLaunchMiniProgram$LaunchPreconditionTask.jof = i;
        if (AppBrandMainProcessService.b(jsApiLaunchMiniProgram$LaunchPreconditionTask)) {
            a kB = a.kB(jsApiLaunchMiniProgram$LaunchPreconditionTask.jog);
            if (kB == null) {
                kB = a.joh;
            }
            if (a.joj != kB) {
                jVar.E(i2, eVar.e(kB.fpb, null));
                return;
            }
            c.a(jVar.mAppId, c$c.LAUNCH_MINI_PROGRAM);
            MMToClientEvent.a(new 2(eVar, str, i, jVar, i2));
            if (jVar.getContext() != null && (jVar.getContext() instanceof Activity) && !jVar.getContext().isFinishing()) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1037;
                AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(jVar.mAppId);
                if (oT != null) {
                    appBrandStatObject.fIr = oT.fIr;
                }
                String str4 = "";
                p b = JsApiLaunchMiniProgram.b(jVar);
                if (b != null) {
                    str4 = b.aeO();
                }
                appBrandStatObject.fnp = jVar.mAppId + ":" + jVar.irP.iqw.irG;
                AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                appBrandLaunchReferrer.appId = jVar.mAppId;
                appBrandLaunchReferrer.iOe = str3;
                appBrandLaunchReferrer.iOd = 1;
                appBrandLaunchReferrer.url = str4;
                AppBrandLaunchProxyUI.a(jVar.getContext(), null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                Assert.assertTrue(true);
                return;
            }
            return;
        }
        jVar.E(i2, eVar.e("fail precondition error", null));
    }
}
