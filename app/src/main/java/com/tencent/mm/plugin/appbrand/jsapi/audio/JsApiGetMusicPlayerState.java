package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState extends a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState jeF;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.jeF = new GetMusicPlayerState(this, jVar, i);
        this.jeF.jeG = jVar.mAppId;
        AppBrandMainProcessService.a(this.jeF);
    }
}
