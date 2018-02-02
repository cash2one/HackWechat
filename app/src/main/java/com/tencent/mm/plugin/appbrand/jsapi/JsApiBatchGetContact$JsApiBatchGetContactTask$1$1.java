package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.TimerTask;

class JsApiBatchGetContact$JsApiBatchGetContactTask$1$1 extends TimerTask {
    final /* synthetic */ boolean[] jcQ;
    final /* synthetic */ Timer jcR;
    final /* synthetic */ 1 jcS;

    JsApiBatchGetContact$JsApiBatchGetContactTask$1$1(1 1, boolean[] zArr, Timer timer) {
        this.jcS = 1;
        this.jcQ = zArr;
        this.jcR = timer;
    }

    public final void run() {
        synchronized (JsApiBatchGetContact.class) {
            if (this.jcQ[0]) {
                x.i("MicroMsg.JsApiBatchGetContact", "isCallBacked");
            } else {
                this.jcQ[0] = true;
                x.w("MicroMsg.JsApiBatchGetContact", "get contact timeout");
                this.jcS.jcP.fnL = "fail:get contact timeout";
                this.jcS.jcP.afp();
            }
        }
        cancel();
        this.jcR.cancel();
    }
}
