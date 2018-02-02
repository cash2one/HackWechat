package com.tencent.mm.plugin.clean.c;

class f$2 implements Runnable {
    final /* synthetic */ f lfG;
    final /* synthetic */ long lfH;

    f$2(f fVar, long j) {
        this.lfG = fVar;
        this.lfH = j;
    }

    public final void run() {
        if (f.a(this.lfG) != null) {
            f.a(this.lfG).bW(this.lfH);
        }
    }
}
