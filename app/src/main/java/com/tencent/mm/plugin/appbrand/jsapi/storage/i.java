package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString3 = jSONObject.optString("dataType");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > jVar.irP.iqx.iOJ.iNs) {
            jVar.E(i, e("fail:entry size limit reached", null));
            return;
        }
        MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = jVar.mAppId;
        jsApiSetStorageTask.A(optString, optString2, optString3);
        jsApiSetStorageTask.jcI = new 1(this, jVar, i, jsApiSetStorageTask);
        jsApiSetStorageTask.afi();
        AppBrandMainProcessService.a(jsApiSetStorageTask);
    }
}
