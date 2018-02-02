package com.tencent.mm.plugin.voip.model;

class j$8 implements Runnable {
    final /* synthetic */ boolean smA;
    final /* synthetic */ int smB;
    final /* synthetic */ j smu;
    final /* synthetic */ int[] smz;

    j$8(j jVar, int[] iArr, boolean z, int i) {
        this.smu = jVar;
        this.smz = iArr;
        this.smA = z;
        this.smB = i;
    }

    public final void run() {
        if (j.c(this.smu) != null) {
            j.c(this.smu).l(this.smz);
        }
        if (j.j(this.smu) != null) {
            j.j(this.smu);
        }
    }
}
