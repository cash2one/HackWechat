package com.tencent.mm.plugin.talkroom.model;

class g$4 implements Runnable {
    final /* synthetic */ int kss;
    final /* synthetic */ g scg;

    g$4(g gVar, int i) {
        this.scg = gVar;
        this.kss = i;
    }

    public final void run() {
        g.a(this.scg, this.kss - 1);
    }
}
