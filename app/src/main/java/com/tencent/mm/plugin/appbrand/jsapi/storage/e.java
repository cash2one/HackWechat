package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends l {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    public final String a(j jVar, JSONObject jSONObject) {
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = jVar.mAppId;
        AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("keys", jsApiGetStorageInfoTask.jrs);
        hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
        hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.asN));
        return e("ok", hashMap);
    }
}
