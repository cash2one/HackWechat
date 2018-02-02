package com.tencent.mm.plugin.g.a.b;

class e$4 implements Runnable {
    final /* synthetic */ long kxD;
    final /* synthetic */ f kxE;
    final /* synthetic */ e kxy;

    public e$4(e eVar, long j, f fVar) {
        this.kxy = eVar;
        this.kxD = j;
        this.kxE = fVar;
    }

    public final void run() {
        this.kxy.kwL.put(Long.valueOf(this.kxD), this.kxE);
    }
}
