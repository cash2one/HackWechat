package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = jVar.mAppId;
        jsApiGetStorageInfoTask.jcI = new 1(this, jsApiGetStorageInfoTask, jVar, i);
        jsApiGetStorageInfoTask.afi();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
    }
}
