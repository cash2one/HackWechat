package com.tencent.mm.aq;

import com.tencent.mm.aq.n.d;

class l$6 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ long hBP;
    final /* synthetic */ l hBQ;
    final /* synthetic */ int hBS;

    l$6(l lVar, long j, int i, int i2) {
        this.hBQ = lVar;
        this.hBP = j;
        this.hBA = i;
        this.hBS = i2;
    }

    public final void run() {
        n Pn = n.Pn();
        long j = this.hBP;
        long j2 = (long) this.hBA;
        long j3 = (long) this.hBS;
        d dVar = Pn.hBW.containsKey(Long.valueOf(j)) ? (d) Pn.hBW.get(Long.valueOf(j)) : new d();
        dVar.oJ = j3;
        dVar.fzM = j2;
        Pn.hBW.put(Long.valueOf(j), dVar);
        l.F(this.hBQ).a(this.hBS, this.hBA, this.hBQ);
    }
}
