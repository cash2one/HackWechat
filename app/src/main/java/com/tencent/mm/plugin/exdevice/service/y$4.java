package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class y$4 implements Runnable {
    final /* synthetic */ int lKT;
    final /* synthetic */ y lQK;
    final /* synthetic */ j lQL;

    y$4(y yVar, int i, j jVar) {
        this.lQK = yVar;
        this.lKT = i;
        this.lQL = jVar;
    }

    public final void run() {
        if (!y.b(this.lQK, this.lKT, this.lQL)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
        }
    }
}
