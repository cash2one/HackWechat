package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateBackgroundAudio$2 extends b {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ u.b jeN;
    final /* synthetic */ JsApiOperateBackgroundAudio jeO;

    JsApiOperateBackgroundAudio$2(JsApiOperateBackgroundAudio jsApiOperateBackgroundAudio, u.b bVar, j jVar, int i) {
        this.jeO = jsApiOperateBackgroundAudio;
        this.jeN = bVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void onDestroy() {
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", new Object[]{this.jeN.getString("appId", "")});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        MainProcessTask jsApiOperateBackgroundAudio$OperateBackgroundAudioTask = new JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(this.jeO, this.iZy, this.gOK);
        jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.jeR = jSONObject.toString();
        jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.appId = r0;
        AppBrandMainProcessService.b(jsApiOperateBackgroundAudio$OperateBackgroundAudioTask);
    }
}
