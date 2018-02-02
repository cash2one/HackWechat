package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.w;

class GameCenterBaseUI$1 implements Runnable {
    final /* synthetic */ GameCenterBaseUI nmB;

    GameCenterBaseUI$1(GameCenterBaseUI gameCenterBaseUI) {
        this.nmB = gameCenterBaseUI;
    }

    public final void run() {
        GameCenterBaseUI.a(this.nmB);
        if (this.nmB.nmv) {
            GameCenterBaseUI.b(this.nmB);
            SubCoreGameCenter.aRe();
            w.aQq();
        }
    }
}
