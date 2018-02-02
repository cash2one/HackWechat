package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;

class b$3 implements Runnable {
    final /* synthetic */ b iIN;
    final /* synthetic */ boolean iIO;
    final /* synthetic */ long iIP;
    final /* synthetic */ Bundle iIQ;

    b$3(b bVar, boolean z, long j, Bundle bundle) {
        this.iIN = bVar;
        this.iIO = z;
        this.iIP = j;
        this.iIQ = bundle;
    }

    public final void run() {
        b.a(this.iIN, 3, ((this.iIO & 1) != 0 ? 2 : 0) | 1, this.iIP, this.iIO, this.iIQ);
    }
}
