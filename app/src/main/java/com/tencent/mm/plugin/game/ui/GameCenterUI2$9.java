package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;

class GameCenterUI2$9 implements Runnable {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$9(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void run() {
        SubCoreGameCenter.aRh().a("pb_index_2", GameCenterUI2.n(this.nnh));
    }
}
