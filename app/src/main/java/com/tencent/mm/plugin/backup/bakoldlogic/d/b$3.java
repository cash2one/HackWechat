package com.tencent.mm.plugin.backup.bakoldlogic.d;

class b$3 implements Runnable {
    final /* synthetic */ b ksn;
    final /* synthetic */ Runnable ksr;
    final /* synthetic */ int kss;

    b$3(b bVar, Runnable runnable, int i) {
        this.ksn = bVar;
        this.ksr = runnable;
        this.kss = i;
    }

    public final void run() {
        this.ksn.a(this.ksr, this.kss - 1);
    }
}
