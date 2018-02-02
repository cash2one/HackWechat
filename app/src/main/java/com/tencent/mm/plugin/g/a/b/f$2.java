package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f kxN;

    f$2(f fVar) {
        this.kxN = fVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", b.cK(f.g(this.kxN)), f.h(this.kxN).getName());
        if (f.i(this.kxN) != null) {
            f.i(this.kxN).h(f.g(this.kxN), false);
        }
        f.j(this.kxN);
    }
}
