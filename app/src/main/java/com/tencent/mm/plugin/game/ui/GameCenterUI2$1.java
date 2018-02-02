package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.w;

class GameCenterUI2$1 implements Runnable {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$1(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void run() {
        GameCenterUI2.a(this.nnh);
        if (GameCenterUI2.b(this.nnh)) {
            GameCenterUI2.c(this.nnh);
            GameCenterUI2.d(this.nnh);
            SubCoreGameCenter.aRe();
            w.aQo();
            SubCoreGameCenter.aRe();
            w.aQq();
        }
    }
}
