package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.ui.GameDetailUI2.14;

class GameDetailUI2$14$1 implements Runnable {
    final /* synthetic */ af npC;
    final /* synthetic */ 14 npE;

    GameDetailUI2$14$1(14 14, af afVar) {
        this.npE = 14;
        this.npC = afVar;
    }

    public final void run() {
        GameDetailUI2.a(this.npE.npz, this.npC);
        if (this.npE.npz.lNB != null) {
            this.npE.npz.lNB.dismiss();
        }
    }
}
