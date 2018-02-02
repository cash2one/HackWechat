package com.tencent.mm.plugin.gif;

class c$4 implements Runnable {
    final /* synthetic */ c nzg;

    c$4(c cVar) {
        this.nzg = cVar;
    }

    public final void run() {
        MMGIFJNI.reset(c.d(this.nzg));
    }
}
