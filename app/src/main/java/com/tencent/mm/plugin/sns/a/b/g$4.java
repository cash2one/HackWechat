package com.tencent.mm.plugin.sns.a.b;

class g$4 implements Runnable {
    final /* synthetic */ long gKR;
    final /* synthetic */ long qPe;
    final /* synthetic */ boolean qPf;
    final /* synthetic */ g qPg;

    g$4(g gVar, long j, long j2, boolean z) {
        this.qPg = gVar;
        this.qPe = j;
        this.gKR = j2;
        this.qPf = z;
    }

    public final void run() {
        if (this.qPg.ei(this.qPe)) {
            g gVar = this.qPg;
            long j = this.qPe;
            long j2 = this.gKR;
            boolean z = this.qPf;
            h hVar = z ? gVar.qOU.containsKey(Long.valueOf(j)) ? (h) gVar.qOU.get(Long.valueOf(j)) : new h("timeline") : gVar.qOT.containsKey(Long.valueOf(j)) ? (h) gVar.qOT.get(Long.valueOf(j)) : new h("timeline");
            if (hVar.qPt.qQv == 0) {
                hVar.qPt.qQv = j2;
            }
            if (z) {
                gVar.qOU.put(Long.valueOf(j), hVar);
            } else {
                gVar.qOT.put(Long.valueOf(j), hVar);
            }
        }
    }
}
