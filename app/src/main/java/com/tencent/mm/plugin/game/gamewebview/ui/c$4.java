package com.tencent.mm.plugin.game.gamewebview.ui;

class c$4 implements Runnable {
    final /* synthetic */ c mYA;
    final /* synthetic */ boolean mYD;

    c$4(c cVar, boolean z) {
        this.mYA = cVar;
        this.mYD = z;
    }

    public final void run() {
        b bVar = (b) c.a(this.mYA).peek();
        c.a(this.mYA, bVar, (b) c.a(this.mYA).pop(), this.mYD);
    }
}
