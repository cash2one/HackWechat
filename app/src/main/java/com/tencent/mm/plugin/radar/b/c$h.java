package com.tencent.mm.plugin.radar.b;

final class c$h implements Runnable {
    final /* synthetic */ c pwG;
    final /* synthetic */ String pwM;
    final /* synthetic */ long pwN;
    final /* synthetic */ boolean pwR;
    final /* synthetic */ boolean pwS;
    final /* synthetic */ String pwT;

    c$h(c cVar, boolean z, boolean z2, String str, String str2, long j) {
        this.pwG = cVar;
        this.pwR = z;
        this.pwS = z2;
        this.pwT = str;
        this.pwM = str2;
        this.pwN = j;
    }

    public final void run() {
        this.pwG.pwB.a(this.pwR, this.pwS, this.pwT, this.pwM, this.pwN);
    }
}
