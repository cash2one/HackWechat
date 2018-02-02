package com.tencent.mm.plugin.exdevice.service;

class b$4 implements Runnable {
    final /* synthetic */ b lPV;
    final /* synthetic */ long lPY;
    final /* synthetic */ long lPZ;

    b$4(b bVar, long j, long j2) {
        this.lPV = bVar;
        this.lPY = j;
        this.lPZ = j2;
    }

    public final void run() {
        b.a(this.lPV, this.lPY, this.lPZ);
    }
}
