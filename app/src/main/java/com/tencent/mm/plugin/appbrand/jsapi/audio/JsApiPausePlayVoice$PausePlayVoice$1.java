package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice;

class JsApiPausePlayVoice$PausePlayVoice$1 implements Runnable {
    final /* synthetic */ PausePlayVoice jfs;

    JsApiPausePlayVoice$PausePlayVoice$1(PausePlayVoice pausePlayVoice) {
        this.jfs = pausePlayVoice;
    }

    public final void run() {
        ((d) g.h(d.class)).pause();
    }
}
