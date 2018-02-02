package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.auth.b.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiOperateWXData extends b {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    public final /* bridge */ /* synthetic */ void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i, a aVar) {
        try {
            String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
            MainProcessTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = jVar.mAppId;
            operateWXDataTask.jfW = NAME;
            AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
            if (appBrandSysConfig != null) {
                operateWXDataTask.iKd = appBrandSysConfig.iOI.iGK;
            }
            operateWXDataTask.jfT = this;
            operateWXDataTask.jcM = jVar;
            operateWXDataTask.jgi = string;
            operateWXDataTask.jcN = i;
            operateWXDataTask.jfU = aVar;
            operateWXDataTask.jga = new Bundle();
            AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(operateWXDataTask.appId);
            if (oT != null) {
                operateWXDataTask.jdU = oT.scene;
            }
            operateWXDataTask.afi();
            AppBrandMainProcessService.a(operateWXDataTask);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiOperateWXData", "Exception %s", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
