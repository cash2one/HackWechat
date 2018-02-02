package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice jfr;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.jfr = new PausePlayVoice((byte) 0);
        AppBrandMainProcessService.a(this.jfr);
        jVar.E(i, e("ok", null));
    }
}
