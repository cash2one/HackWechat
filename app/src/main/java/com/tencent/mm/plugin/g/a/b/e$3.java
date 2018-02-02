package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

class e$3 implements Runnable {
    final /* synthetic */ e kxy;

    e$3(e eVar) {
        this.kxy = eVar;
    }

    public final void run() {
        this.kxy.kwN.a(false, this.kxy.kwQ);
        x.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
    }
}
