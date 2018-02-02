package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiChooseVideo$2 implements b<ChooseResult> {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiChooseVideo jnq;

    JsApiChooseVideo$2(JsApiChooseVideo jsApiChooseVideo, j jVar, int i) {
        this.jnq = jsApiChooseVideo;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final /* synthetic */ void c(ProcessResult processResult) {
        ChooseResult chooseResult = (ChooseResult) processResult;
        if (chooseResult != null) {
            switch (chooseResult.bjW) {
                case -1:
                    AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.jns;
                    if (appBrandLocalVideoObject == null) {
                        x.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                        break;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("tempFilePath", appBrandLocalVideoObject.fus);
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                    hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                    hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                    hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                    this.iZy.E(this.gOK, this.jnq.e("ok", hashMap));
                    return;
                case 0:
                    this.iZy.E(this.gOK, this.jnq.e("cancel", null));
                    return;
            }
        }
        this.iZy.E(this.gOK, this.jnq.e("fail", null));
    }
}
