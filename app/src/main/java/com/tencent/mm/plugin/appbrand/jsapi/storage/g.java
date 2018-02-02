package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = jVar.mAppId;
        jsApiRemoveStorageTask.aAM = optString;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        jVar.E(i, e("ok", null));
    }
}
