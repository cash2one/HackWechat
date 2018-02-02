package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = jVar.mAppId;
        AppBrandMainProcessService.a(jsApiClearStorageTask);
        jVar.E(i, e("ok", null));
    }
}
