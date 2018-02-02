package com.tencent.mm.bg;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.sdk.platformtools.af;

class b$2 extends af {
    final /* synthetic */ b hYe;

    b$2(b bVar, Looper looper) {
        this.hYe = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == JsApiCreateAudioInstance.CTRL_INDEX && this.hYe.UP()) {
            g.CG().a(this.hYe, 0);
        }
    }
}
