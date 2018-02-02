package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u$b;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$2 extends b {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ u$b jeN;
    final /* synthetic */ JsApiSetBackgroundAudioState jfw;

    JsApiSetBackgroundAudioState$2(JsApiSetBackgroundAudioState jsApiSetBackgroundAudioState, u$b com_tencent_mm_z_u_b, j jVar, int i) {
        this.jfw = jsApiSetBackgroundAudioState;
        this.jeN = com_tencent_mm_z_u_b;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void onDestroy() {
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[]{this.jeN.getString("appId", "")});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        MainProcessTask jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(this.jfw, this.iZy, this.gOK);
        jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask.jeR = jSONObject.toString();
        jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask.appId = r0;
        AppBrandMainProcessService.b(jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask);
    }
}
