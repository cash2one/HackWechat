package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.ae.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.1;

class JsApiStartPlayVoice$StartPlayVoice$1$2 implements b {
    final /* synthetic */ 1 jfE;

    JsApiStartPlayVoice$StartPlayVoice$1$2(1 1) {
        this.jfE = 1;
    }

    public final void onError() {
        this.jfE.jfD.jeA = true;
        StartPlayVoice.c(this.jfE.jfD);
    }
}
