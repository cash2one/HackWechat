package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends l {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    public final String a(j jVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bh.ov(optString)) {
            return e("fail", null);
        }
        MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = jVar.mAppId;
        jsApiGetStorageTask.aAM = optString;
        AppBrandMainProcessService.b(jsApiGetStorageTask);
        optString = jsApiGetStorageTask.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
        hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
        return e(optString, hashMap);
    }
}
