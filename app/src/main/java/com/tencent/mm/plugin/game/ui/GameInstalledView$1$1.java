package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.GameInstalledView.1;

class GameInstalledView$1$1 implements Runnable {
    final /* synthetic */ 1 nsb;

    GameInstalledView$1$1(1 1) {
        this.nsb = 1;
    }

    public final void run() {
        if (GameInstalledView.a(this.nsb.nsa) == 0) {
            GameInstalledView.b(this.nsb.nsa);
            GameInstalledView.c(this.nsb.nsa).addView(this.nsb.zS, this.nsb.nsa.nrZ);
        }
    }
}
