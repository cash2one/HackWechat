package com.tencent.mm.plugin.radar.b;

final class c$l implements Runnable {
    final /* synthetic */ c pwG;
    final /* synthetic */ String pwM;
    final /* synthetic */ long pwN;
    final /* synthetic */ boolean pwR;
    final /* synthetic */ String pwT;

    c$l(c cVar, boolean z, String str, String str2, long j) {
        this.pwG = cVar;
        this.pwR = z;
        this.pwT = str;
        this.pwM = str2;
        this.pwN = j;
    }

    public final void run() {
        this.pwG.pwB.a(this.pwR, this.pwT, this.pwM, this.pwN);
    }
}
