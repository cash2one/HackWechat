package com.tencent.mm.plugin.sns.a.b;

class g$2 implements Runnable {
    final /* synthetic */ int jqi;
    final /* synthetic */ long qPe;
    final /* synthetic */ boolean qPf;
    final /* synthetic */ g qPg;
    final /* synthetic */ boolean qPh;

    g$2(g gVar, long j, int i, boolean z, boolean z2) {
        this.qPg = gVar;
        this.qPe = j;
        this.jqi = i;
        this.qPh = z;
        this.qPf = z2;
    }

    public final void run() {
        this.qPg.b(this.qPe, this.jqi, this.qPh, this.qPf);
    }
}
