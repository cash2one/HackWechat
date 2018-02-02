package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiLogin extends b {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";

    public final /* bridge */ /* synthetic */ void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i, b$a com_tencent_mm_plugin_appbrand_jsapi_auth_b_a) {
        MainProcessTask loginTask = new LoginTask();
        loginTask.appId = jVar.mAppId;
        loginTask.jfW = "login";
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (appBrandSysConfig != null) {
            loginTask.iKd = appBrandSysConfig.iOI.iGK;
        }
        AppBrandStatObject oT = a.oT(jVar.mAppId);
        if (oT != null) {
            loginTask.jdU = oT.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.jfT = this;
        loginTask.jcM = jVar;
        loginTask.data = jSONObject2;
        loginTask.jcN = i;
        loginTask.jfU = com_tencent_mm_plugin_appbrand_jsapi_auth_b_a;
        loginTask.jga = new Bundle();
        loginTask.afi();
        AppBrandMainProcessService.a(loginTask);
    }
}
