package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class k$a implements Runnable {
    int index;
    final /* synthetic */ k oHh;

    k$a(k kVar, int i) {
        this.oHh = kVar;
        this.index = i;
    }

    public final void run() {
        Looper.prepare();
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
        this.oHh.oHb[this.index] = new af();
        Looper.loop();
    }
}
