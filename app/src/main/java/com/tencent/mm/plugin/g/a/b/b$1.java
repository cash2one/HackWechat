package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b kwS;

    b$1(b bVar) {
        this.kwS = bVar;
    }

    public final void run() {
        this.kwS.kwM = false;
        this.kwS.dR(false);
        x.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
        this.kwS.arj();
        if (this.kwS.kwK != null) {
            this.kwS.kwK.arl();
        }
    }
}
