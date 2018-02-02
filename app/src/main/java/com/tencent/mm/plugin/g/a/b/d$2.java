package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ d kxs;

    d$2(d dVar) {
        this.kxs = dVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (this.kxs.kxg != null) {
            this.kxs.kxg.kwK.h(this.kxs.mSessionId, false);
        }
        this.kxs.aro();
    }
}
