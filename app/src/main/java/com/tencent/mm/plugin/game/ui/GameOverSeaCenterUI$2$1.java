package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2;

class GameOverSeaCenterUI$2$1 implements Runnable {
    final /* synthetic */ 2 ntR;

    GameOverSeaCenterUI$2$1(2 2) {
        this.ntR = 2;
    }

    public final void run() {
        if (!this.ntR.ntQ.isFinishing()) {
            this.ntR.ntQ.lNB = c.cR(this.ntR.ntQ);
            this.ntR.ntQ.lNB.show();
        }
    }
}
