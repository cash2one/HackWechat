package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$5 implements Runnable {
    final /* synthetic */ b lPV;
    final /* synthetic */ long lQa;
    final /* synthetic */ byte[] lQb;

    b$5(b bVar, long j, byte[] bArr) {
        this.lPV = bVar;
        this.lQa = j;
        this.lQb = bArr;
    }

    public final void run() {
        if (!b.a(this.lPV, this.lQa, this.lQb)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
        }
    }
}
