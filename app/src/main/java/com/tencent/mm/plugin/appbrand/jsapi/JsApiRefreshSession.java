package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiRefreshSession extends a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        MainProcessTask refreshSessionTask = new RefreshSessionTask();
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (appBrandSysConfig != null) {
            RefreshSessionTask.a(refreshSessionTask, appBrandSysConfig.iOI.iGK);
        }
        String str = jVar.mAppId;
        refreshSessionTask.jdQ = this;
        refreshSessionTask.jcM = jVar;
        refreshSessionTask.jcN = i;
        refreshSessionTask.appId = str;
        AppBrandStatObject oT = a.oT(str);
        if (oT != null) {
            refreshSessionTask.jdU = oT.scene;
        }
        refreshSessionTask.afi();
        AppBrandMainProcessService.a(refreshSessionTask);
    }
}
