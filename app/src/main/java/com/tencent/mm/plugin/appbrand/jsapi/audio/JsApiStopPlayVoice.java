package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("localId");
        x.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", new Object[]{jVar.mAppId, optString});
        AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
        jVar.E(i, e("ok", null));
        JsApiStartPlayVoice.jfz = null;
    }

    public static void afB() {
        if (!bh.ov(JsApiStartPlayVoice.jfz)) {
            AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
            JsApiStartPlayVoice.jfz = null;
        }
    }
}
