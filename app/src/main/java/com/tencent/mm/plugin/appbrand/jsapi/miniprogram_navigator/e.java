package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

final class e {

    public static final class a {
        public int fIs;
        public String fIt;
        public String fnp;
        public int scene;
    }

    interface b {
        void cO(boolean z);
    }

    static void a(j jVar, String str, int i, int i2, String str2, a aVar, JSONObject jSONObject, b bVar) {
        String str3;
        x.i("MicroMsg.MiniProgramNavigator", "navigateTo sourceType:%d", Integer.valueOf(i2));
        String str4 = "";
        n nVar = jVar.irP.iqC;
        p aex = (nVar == null || nVar.aiT() == null) ? null : nVar.aiT().aex();
        if (aex != null) {
            str4 = aex.aeO();
        }
        String str5 = jVar.mAppId + ":" + jVar.irP.iqw.irG;
        AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(jVar.mAppId);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        int i3 = (aVar == null || aVar.scene == 0) ? 1037 : aVar.scene;
        appBrandStatObject.scene = i3;
        appBrandStatObject.fIr = oT.fIr;
        if (aVar == null || aVar.scene == 0 || bh.ov(aVar.fnp)) {
            str3 = str5;
        } else {
            str3 = String.format("%s:%s", new Object[]{str5, aVar.fnp});
        }
        appBrandStatObject.fnp = str3;
        appBrandStatObject.fIs = aVar != null ? aVar.fIs : 0;
        appBrandStatObject.fIt = aVar != null ? aVar.fIt : null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = jVar.mAppId;
        appBrandLaunchReferrer.iOe = jSONObject == null ? "{}" : jSONObject.toString();
        appBrandLaunchReferrer.iOd = 1;
        appBrandLaunchReferrer.url = str4;
        appBrandLaunchReferrer.fqd = i2;
        i.pm(jVar.mAppId).irN = str;
        i.pm(jVar.mAppId).irO = str2;
        MainProcessTask appBrandPreInitTask = new AppBrandPreInitTask(str, i, appBrandStatObject, new 1(bVar, str2, appBrandLaunchReferrer, jVar, str, i, appBrandStatObject));
        appBrandPreInitTask.afi();
        AppBrandMainProcessService.a(appBrandPreInitTask);
    }
}
