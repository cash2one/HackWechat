package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ int lKT;
    final /* synthetic */ b lPV;
    final /* synthetic */ r lPW;
    final /* synthetic */ int[] lPX;

    b$2(b bVar, int i, r rVar, int[] iArr) {
        this.lPV = bVar;
        this.lKT = i;
        this.lPW = rVar;
        this.lPX = iArr;
    }

    public final void run() {
        if (!b.a(this.lPV, this.lKT, this.lPW, this.lPX)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
        }
    }
}
