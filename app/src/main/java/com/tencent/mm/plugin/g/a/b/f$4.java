package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

class f$4 implements Runnable {
    final /* synthetic */ f kxN;

    f$4(f fVar) {
        this.kxN = fVar;
    }

    public final void run() {
        if (f.k(this.kxN)) {
            if (f.i(this.kxN) != null) {
                f.i(this.kxN).a(f.g(this.kxN), false, f.l(this.kxN));
            }
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
            f.m(this.kxN);
        }
    }
}
