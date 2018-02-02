package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.media.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import org.json.JSONObject;

public final class JsApiSetAudioState extends a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private AudioPlayerEventListenerTask jeJ;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (!JsApiCreateAudioInstance.jew) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            jVar.E(i, e("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[]{jSONObject.toString()});
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            String optString2 = jSONObject.optString("src");
            if (bh.ov(optString2)) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
                optString2 = "";
            } else if (!optString2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[]{optString2});
            } else if (jVar.irP == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime() is null");
                optString2 = "";
            } else if (jVar.irP.iqz == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
                optString2 = "";
            } else {
                File pQ = jVar.irP.iqz.pQ(optString2);
                if (pQ == null || !pQ.exists()) {
                    x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
                    optString2 = "";
                } else {
                    optString2 = pQ.getAbsolutePath();
                    if (!(optString2 == null || optString2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX))) {
                        optString2 = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(optString2).toString();
                    }
                    x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[]{optString2});
                }
            }
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                jVar.E(i, e("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                jVar.E(i, e("fail:src is empty", null));
            } else {
                String str;
                if (this.jeJ == null) {
                    this.jeJ = new AudioPlayerEventListenerTask(this, jVar, i);
                }
                this.jeJ.appId = jVar.mAppId;
                AppBrandMainProcessService.a(this.jeJ);
                MainProcessTask setAudioTask = new SetAudioTask(this, jVar, i);
                setAudioTask.appId = jVar.mAppId;
                setAudioTask.fnF = optString;
                setAudioTask.hkD = optString2;
                setAudioTask.hkt = optInt;
                setAudioTask.hkv = optBoolean;
                setAudioTask.hkw = optBoolean2;
                if (jVar.irP == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime() is null");
                    str = "";
                } else if (jVar.irP.iqx == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
                    str = "";
                } else if (jVar.irP.iqx.iOI == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
                    str = "";
                } else {
                    x.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", new Object[]{jVar.irP.iqx.iOI.iEa});
                    str = jVar.irP.iqx.iOI.iEa;
                }
                setAudioTask.iEa = str;
                setAudioTask.hky = optDouble;
                setAudioTask.processName = ac.Br();
                AppBrandMainProcessService.a(setAudioTask);
                h hVar = new h();
                hVar.iEa = setAudioTask.iEa;
                hVar.jeL = jSONObject.toString();
                hVar.hkD = optString2;
                com.tencent.mm.plugin.appbrand.media.a.a(optString, hVar);
            }
        }
    }
}
