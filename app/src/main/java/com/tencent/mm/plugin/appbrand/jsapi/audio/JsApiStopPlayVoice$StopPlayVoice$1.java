package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice;

class JsApiStopPlayVoice$StopPlayVoice$1 implements Runnable {
    final /* synthetic */ StopPlayVoice jfM;

    JsApiStopPlayVoice$StopPlayVoice$1(StopPlayVoice stopPlayVoice) {
        this.jfM = stopPlayVoice;
    }

    public final void run() {
        ((d) g.h(d.class)).stop();
    }
}
