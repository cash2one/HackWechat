package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;

public final class JsApiOperateBackgroundAudio$b extends f {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioPrev";
    private static final JsApiOperateBackgroundAudio$b jeQ = new JsApiOperateBackgroundAudio$b();

    static synchronized void c(c cVar) {
        synchronized (JsApiOperateBackgroundAudio$b.class) {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
            jeQ.a(cVar).afs();
        }
    }
}
