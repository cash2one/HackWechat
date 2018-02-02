package com.tencent.mm.plugin.voip.model;

class j$15 implements Runnable {
    final /* synthetic */ int fhx;
    final /* synthetic */ j smu;

    j$15(j jVar, int i) {
        this.smu = jVar;
        this.fhx = i;
    }

    public final void run() {
        if (j.j(this.smu) != null) {
            j.j(this.smu).dQ(this.fhx, j.a(this.smu).mState);
        }
    }
}
