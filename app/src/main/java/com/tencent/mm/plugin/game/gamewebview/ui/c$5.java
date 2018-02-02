package com.tencent.mm.plugin.game.gamewebview.ui;

class c$5 implements Runnable {
    final /* synthetic */ boolean jCE;
    final /* synthetic */ boolean jDw;
    final /* synthetic */ c mYA;
    final /* synthetic */ b mYC;

    c$5(c cVar, boolean z, b bVar, boolean z2) {
        this.mYA = cVar;
        this.jCE = z;
        this.mYC = bVar;
        this.jDw = z2;
    }

    public final void run() {
        if (this.jCE) {
            this.mYC.fv(true);
            this.mYC.hide();
        }
        if (this.jDw) {
            c.b(this.mYA, this.mYC);
        }
    }
}
