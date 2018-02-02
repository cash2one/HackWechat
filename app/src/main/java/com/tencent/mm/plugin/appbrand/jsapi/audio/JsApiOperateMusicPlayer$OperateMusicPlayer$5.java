package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOperateMusicPlayer$OperateMusicPlayer$5 implements Runnable {
    final /* synthetic */ OperateMusicPlayer jfe;

    JsApiOperateMusicPlayer$OperateMusicPlayer$5(OperateMusicPlayer operateMusicPlayer) {
        this.jfe = operateMusicPlayer;
    }

    public final void run() {
        x.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
        this.jfe.action = -1;
        this.jfe.jeA = false;
        this.jfe.errorMsg = "";
        OperateMusicPlayer.g(this.jfe);
    }
}
