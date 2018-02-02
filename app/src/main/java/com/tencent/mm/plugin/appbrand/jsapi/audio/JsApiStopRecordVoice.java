package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class JsApiStopRecordVoice extends a {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        d(jVar);
        jVar.E(i, e("ok", null));
    }

    static void d(j jVar) {
        if (!bh.ov(JsApiStartRecordVoice.jfF)) {
            com.tencent.mm.plugin.appbrand.page.a.q(jVar.irP).la(i.pl(jVar.mAppId).irL);
            AppBrandMainProcessService.a(new StopRecordVoice((byte) 0));
            JsApiStartRecordVoice.jfF = null;
        }
    }
}
