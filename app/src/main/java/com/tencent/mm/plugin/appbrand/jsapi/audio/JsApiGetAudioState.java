package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class JsApiGetAudioState extends a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            jVar.E(i, e("fail:audioId is empty", null));
            return;
        }
        MainProcessTask getAudioStateTask = new GetAudioStateTask(this, jVar, i);
        getAudioStateTask.appId = jVar.mAppId;
        getAudioStateTask.fnF = optString;
        AppBrandMainProcessService.a(getAudioStateTask);
    }
}
