package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiChooseMedia extends a {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    private static volatile boolean jmX = false;

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jmX) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            jVar.E(i, e("cancel", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            jVar.E(i, e("fail:page context is null", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            boolean z;
            x.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str = jSONObject.optJSONArray("sourceType").toString();
            }
            if (bh.ov(str)) {
                str = "camera|album";
            }
            String str2 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str2 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (bh.ov(str2)) {
                str2 = "video|image";
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            if (min < 3 || min > 10) {
                x.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
                min = 10;
            }
            String optString = jSONObject.optString("camera");
            if (bh.ov(optString)) {
                optString = "back";
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            String str3 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str3 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (bh.ov(str3)) {
                str3 = "original|compressed";
            }
            x.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{str, str2, Integer.valueOf(min), optString, Integer.valueOf(min2), str3});
            com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 3(this, jVar, jSONObject, i));
            Activity a2 = a(jVar);
            if (a2 == null) {
                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                jVar.E(i, e("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
                }
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 4(this, jVar, jSONObject, i));
                a2 = a(jVar);
                if (a2 == null) {
                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                    jVar.E(i, e("fail", null));
                    z = false;
                } else {
                    z = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.CAMERA", 119, "", "");
                    if (z) {
                        com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
                    }
                }
                if (z) {
                    x.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
                    jmX = true;
                    c.a(jVar.mAppId, new 1(this, jVar));
                    ProcessRequest chooseRequest = new ChooseRequest();
                    chooseRequest.appId = jVar.mAppId;
                    chooseRequest.jmZ = str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                    chooseRequest.jna = str.contains("camera");
                    chooseRequest.jnb = str2.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
                    chooseRequest.jnc = str2.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
                    if (optString.contains("back") || !optString.contains("front")) {
                        chooseRequest.isFront = false;
                    } else {
                        chooseRequest.isFront = true;
                    }
                    chooseRequest.maxDuration = min;
                    chooseRequest.count = min2;
                    chooseRequest.jmI = str3.contains("compressed");
                    chooseRequest.jmJ = str3.contains("original");
                    com.tencent.mm.plugin.appbrand.ipc.a.a(a, chooseRequest, new b<ChooseResult>(this) {
                        final /* synthetic */ JsApiChooseMedia jmY;

                        public final /* synthetic */ void c(AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
                            ChooseResult chooseResult = (ChooseResult) appBrandProxyUIProcessTask$ProcessResult;
                            JsApiChooseMedia.jmX = false;
                            if (chooseResult == null) {
                                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                                jVar.E(i, this.jmY.e("fail", null));
                                return;
                            }
                            switch (chooseResult.bjW) {
                                case -1:
                                    String str = chooseResult.type;
                                    String str2 = chooseResult.jnd;
                                    if (bh.ov(str2)) {
                                        x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                        jVar.E(i, this.jmY.e("fail", null));
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put(DownloadSettingTable$Columns.TYPE, str);
                                    hashMap.put("tempFiles", str2);
                                    x.i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", new Object[]{str, str2});
                                    jVar.E(i, this.jmY.e("ok", hashMap));
                                    return;
                                case 0:
                                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                                    jVar.E(i, this.jmY.e("fail:cancel", null));
                                    return;
                                default:
                                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                                    jVar.E(i, this.jmY.e("fail", null));
                                    return;
                            }
                        }
                    });
                    return;
                }
                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                return;
            }
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
        }
    }
}
