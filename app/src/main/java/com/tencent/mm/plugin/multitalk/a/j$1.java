package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ j oGW;

    public j$1(j jVar) {
        this.oGW = jVar;
    }

    public final void run() {
        Looper.prepare();
        x.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
        this.oGW.oGU = new af();
        Looper.loop();
    }
}
