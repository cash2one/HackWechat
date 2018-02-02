package com.tencent.mm.z.d;

import com.tencent.mm.az.k;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class c$1 implements Runnable {
    final /* synthetic */ c hju;

    public c$1(c cVar) {
        this.hju = cVar;
    }

    public final void run() {
        if (c.a(this.hju)) {
            x.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
            return;
        }
        long j = c.b(this.hju).getLong("trace_config_last_update_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
            c.c(this.hju);
            c.d(this.hju);
            ar.CG().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this.hju);
            ar.CG().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this.hju);
            ar.CG().a(new k(21), 0);
            return;
        }
        x.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
    }
}
