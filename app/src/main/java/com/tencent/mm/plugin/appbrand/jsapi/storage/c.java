package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = jVar.mAppId;
        jsApiGetStorageTask.aAM = optString;
        jsApiGetStorageTask.jcI = new 1(this, jsApiGetStorageTask, jVar, i, currentTimeMillis);
        jsApiGetStorageTask.afi();
        AppBrandMainProcessService.a(jsApiGetStorageTask);
    }
}
