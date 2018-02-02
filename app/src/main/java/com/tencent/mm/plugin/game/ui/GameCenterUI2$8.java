package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.az;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;

class GameCenterUI2$8 implements Runnable {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$8(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void run() {
        ar.CG().a(new az(w.cfi(), g.aPX(), GameCenterUI2.k(this.nnh), GameCenterUI2.l(this.nnh), GameCenterUI2.m(this.nnh), GameCenterUI2.b(this.nnh)), 0);
    }
}
