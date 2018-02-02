package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.media.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiOperateAudio extends a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private JsApiSetAudioState$AudioPlayerEventListenerTask jeJ;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (!JsApiCreateAudioInstance.jew) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            jVar.E(i, e("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", jVar.mAppId, jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            Object optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                jVar.E(i, e("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                jVar.E(i, e("fail:operationType is empty", null));
            } else {
                if (this.jeJ == null) {
                    this.jeJ = new JsApiSetAudioState$AudioPlayerEventListenerTask(this, jVar, i);
                }
                this.jeJ.appId = jVar.mAppId;
                AppBrandMainProcessService.a(this.jeJ);
                MainProcessTask operateAudioTask = new OperateAudioTask(this, jVar, i);
                operateAudioTask.appId = jVar.mAppId;
                operateAudioTask.fnF = optString;
                operateAudioTask.fnG = optInt;
                operateAudioTask.jeK = optString2;
                h te = com.tencent.mm.plugin.appbrand.media.a.te(optString);
                if (te != null) {
                    operateAudioTask.jeL = te.jeL;
                    operateAudioTask.iEa = te.iEa;
                    operateAudioTask.hkD = te.hkD;
                }
                operateAudioTask.processName = ac.Br();
                AppBrandMainProcessService.a(operateAudioTask);
            }
        }
    }
}
