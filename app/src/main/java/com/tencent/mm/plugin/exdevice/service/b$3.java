package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ int lKT;
    final /* synthetic */ b lPV;

    b$3(b bVar, int i) {
        this.lPV = bVar;
        this.lKT = i;
    }

    public final void run() {
        if (!b.a(this.lPV, this.lKT)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
        }
    }
}
