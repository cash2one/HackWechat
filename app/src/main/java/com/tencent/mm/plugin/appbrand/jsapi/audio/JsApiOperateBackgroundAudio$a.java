package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;

public final class JsApiOperateBackgroundAudio$a extends f {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final JsApiOperateBackgroundAudio$a jeP = new JsApiOperateBackgroundAudio$a();

    static synchronized void c(c cVar) {
        synchronized (JsApiOperateBackgroundAudio$a.class) {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
            jeP.a(cVar).afs();
        }
    }
}
