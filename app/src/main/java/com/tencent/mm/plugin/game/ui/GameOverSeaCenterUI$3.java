package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;

class GameOverSeaCenterUI$3 implements Runnable {
    final /* synthetic */ GameOverSeaCenterUI ntQ;

    GameOverSeaCenterUI$3(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.ntQ = gameOverSeaCenterUI;
    }

    public final void run() {
        SubCoreGameCenter.aRh().a("pb_over_sea", GameOverSeaCenterUI.c(this.ntQ));
    }
}
