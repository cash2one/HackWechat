package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateBackgroundAudio$1 implements f {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ b jeN;
    final /* synthetic */ JsApiOperateBackgroundAudio jeO;

    JsApiOperateBackgroundAudio$1(JsApiOperateBackgroundAudio jsApiOperateBackgroundAudio, b bVar, j jVar, int i) {
        this.jeO = jsApiOperateBackgroundAudio;
        this.jeN = bVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void ak(String str, int i) {
        String string = this.jeN.getString("appId", "");
        int i2 = this.jeN.getInt("pkgType", 0);
        if ((!string.equals(str) || i2 != i) && this.jeN.hA("operateBackgroundAudio#isPlaying") && c.pf(string) != a.iqe) {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "pause");
            } catch (JSONException e) {
            }
            MainProcessTask jsApiOperateBackgroundAudio$OperateBackgroundAudioTask = new JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(this.jeO, this.iZy, this.gOK);
            jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.jeR = jSONObject.toString();
            jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.appId = string;
            AppBrandMainProcessService.a(jsApiOperateBackgroundAudio$OperateBackgroundAudioTask);
        }
    }
}
