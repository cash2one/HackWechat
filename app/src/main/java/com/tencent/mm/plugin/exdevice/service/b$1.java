package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.g.a.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b lPU;

    b$1(b bVar) {
        this.lPU = bVar;
    }

    public final void run() {
        b.a(this.lPU, new b(ac.getContext(), this.lPU, v.aEN().hOa));
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
        b.a(this.lPU).countDown();
    }
}
