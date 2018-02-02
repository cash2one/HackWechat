package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiDestroyInstanceAudio extends a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            jVar.E(i, e("fail:audioId is empty", null));
            return;
        }
        MainProcessTask destroyAudioTask = new DestroyAudioTask(this, jVar, i);
        destroyAudioTask.appId = jVar.mAppId;
        destroyAudioTask.fnF = optString;
        AppBrandMainProcessService.a(destroyAudioTask);
    }
}
