package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$6 implements Runnable {
    final /* synthetic */ b lPV;
    final /* synthetic */ long lQa;

    b$6(b bVar, long j) {
        this.lPV = bVar;
        this.lQa = j;
    }

    public final void run() {
        if (!b.a(this.lPV, this.lQa)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
        }
    }
}
