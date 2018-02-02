package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import org.json.JSONObject;

public final class JsApiGetSetting extends a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        MainProcessTask getSettingTask = new GetSettingTask();
        getSettingTask.mAppId = jVar.mAppId;
        getSettingTask.jcs = i;
        getSettingTask.iqB = jVar;
        c.bj(getSettingTask);
        AppBrandMainProcessService.a(getSettingTask);
    }
}
