package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ag;

class GameDetailRankUI$1 implements Runnable {
    final /* synthetic */ GameDetailRankUI noz;

    GameDetailRankUI$1(GameDetailRankUI gameDetailRankUI) {
        this.noz = gameDetailRankUI;
    }

    public final void run() {
        GameDetailRankUI.b(this.noz).a(new ag(GameDetailRankUI.a(this.noz)));
    }
}
