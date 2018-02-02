package com.tencent.mm.plugin.backup.c;

class c$4 implements Runnable {
    final /* synthetic */ c klx;
    final /* synthetic */ int kly;

    c$4(c cVar, int i) {
        this.klx = cVar;
        this.kly = i;
    }

    public final void run() {
        if (c.p(this.klx) != null) {
            c.p(this.klx).my(this.kly);
        }
    }
}
