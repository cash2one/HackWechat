package com.tencent.mm.plugin.backup.c;

class d$1 implements Runnable {
    final /* synthetic */ d klM;
    final /* synthetic */ int kly;

    d$1(d dVar, int i) {
        this.klM = dVar;
        this.kly = i;
    }

    public final void run() {
        if (d.a(this.klM) != null) {
            d.a(this.klM).mz(this.kly);
        }
    }
}
