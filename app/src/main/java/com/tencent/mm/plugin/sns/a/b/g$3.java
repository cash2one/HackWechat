package com.tencent.mm.plugin.sns.a.b;

class g$3 implements Runnable {
    final /* synthetic */ long qPe;
    final /* synthetic */ g qPg;
    final /* synthetic */ long qPi;

    g$3(g gVar, long j, long j2) {
        this.qPg = gVar;
        this.qPe = j;
        this.qPi = j2;
    }

    public final void run() {
        if (this.qPg.ei(this.qPe)) {
            g gVar = this.qPg;
            long j = this.qPi;
            if (!gVar.qOS.contains(Long.valueOf(j))) {
                gVar.qOS.add(Long.valueOf(j));
            }
        }
    }
}
