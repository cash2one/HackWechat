package com.tencent.mm.plugin.backup.c;

class c$3 implements Runnable {
    final /* synthetic */ c klx;
    final /* synthetic */ int kly;

    c$3(c cVar, int i) {
        this.klx = cVar;
        this.kly = i;
    }

    public final void run() {
        if (c.o(this.klx) != null) {
            c.o(this.klx).mz(this.kly);
        }
    }
}
