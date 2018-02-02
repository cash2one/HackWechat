package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f kxN;

    f$3(f fVar) {
        this.kxN = fVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[]{b.cK(f.g(this.kxN)), f.h(this.kxN).getName()});
        if (3 == f.e(this.kxN)) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
        } else if (f.e(this.kxN) == 1) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
        } else {
            this.kxN.arp();
        }
    }
}
