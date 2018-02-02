package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo extends a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean jnp = false;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        if (jnp) {
            jVar.E(i, e("cancel", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        ProcessRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        x.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[]{optJSONArray, jSONObject.optString("maxDuration")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.jmG = true;
            chooseRequest.jmH = true;
        } else {
            chooseRequest.jmG = optJSONArray.toString().contains("camera");
            chooseRequest.jmH = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        chooseRequest.jnr = jSONObject.optBoolean("compressed", true);
        if (chooseRequest.jmG) {
            com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 3(this, jVar, jSONObject, i));
            Activity a2 = a(jVar);
            if (a2 == null) {
                jVar.E(i, e("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.CAMERA", 115, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        jnp = true;
        c.a(jVar.mAppId, new 1(this, jVar));
        chooseRequest.maxDuration = bh.getInt(r4, 60);
        chooseRequest.appId = jVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new 2(this, jVar, i));
    }
}
