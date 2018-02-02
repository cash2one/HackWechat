package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import org.json.JSONObject;

public final class b extends l {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    public final String a(j jVar, JSONObject jSONObject) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = jVar.mAppId;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        return e("ok", null);
    }
}
