package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.a.a;

class d$12 implements Runnable {
    final /* synthetic */ int jXy;
    final /* synthetic */ d mZC;

    d$12(d dVar, int i) {
        this.mZC = dVar;
        this.jXy = i;
    }

    public final void run() {
        a.a(this.mZC, this.jXy);
    }
}
