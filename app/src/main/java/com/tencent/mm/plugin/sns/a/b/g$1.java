package com.tencent.mm.plugin.sns.a.b;

class g$1 implements Runnable {
    final /* synthetic */ long qPe;
    final /* synthetic */ boolean qPf;
    final /* synthetic */ g qPg;

    g$1(g gVar, long j, boolean z) {
        this.qPg = gVar;
        this.qPe = j;
        this.qPf = z;
    }

    public final void run() {
        if (this.qPg.ei(this.qPe)) {
            g gVar = this.qPg;
            long j = this.qPe;
            boolean z = this.qPf;
            h hVar = z ? gVar.qOU.containsKey(Long.valueOf(j)) ? (h) gVar.qOU.get(Long.valueOf(j)) : new h("timeline") : gVar.qOT.containsKey(Long.valueOf(j)) ? (h) gVar.qOT.get(Long.valueOf(j)) : new h("timeline");
            hVar.qPl = 1;
            hVar.qPt.qQq++;
            if (z) {
                gVar.qOU.put(Long.valueOf(j), hVar);
            } else {
                gVar.qOT.put(Long.valueOf(j), hVar);
            }
        }
    }
}
