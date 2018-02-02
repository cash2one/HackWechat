package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ d kxs;

    d$3(d dVar) {
        this.kxs = dVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == this.kxs.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
            return;
        }
        this.kxs.mHandler.removeCallbacks(this.kxs.kxm);
        this.kxs.kxq = 2;
        if (this.kxs.kxg != null) {
            this.kxs.kxg.kwK.g(this.kxs.mSessionId, false);
        }
    }
}
