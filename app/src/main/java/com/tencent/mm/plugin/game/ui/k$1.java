package com.tencent.mm.plugin.game.ui;

class k$1 implements Runnable {
    final /* synthetic */ k npQ;

    k$1(k kVar) {
        this.npQ = kVar;
    }

    public final void run() {
        this.npQ.invalidateSelf();
    }
}
