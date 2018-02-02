package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class h extends l {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    public final String a(j jVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bh.ov(optString)) {
            return e("fail", null);
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = jVar.mAppId;
        jsApiRemoveStorageTask.aAM = optString;
        AppBrandMainProcessService.b(jsApiRemoveStorageTask);
        return e("ok", null);
    }
}
