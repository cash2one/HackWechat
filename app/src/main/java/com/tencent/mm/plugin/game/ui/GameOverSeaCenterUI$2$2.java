package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2;
import com.tencent.mm.sdk.platformtools.x;

class GameOverSeaCenterUI$2$2 implements Runnable {
    final /* synthetic */ 2 ntR;
    final /* synthetic */ am ntS;

    GameOverSeaCenterUI$2$2(2 2, am amVar) {
        this.ntR = 2;
        this.ntS = amVar;
    }

    public final void run() {
        try {
            GameOverSeaCenterUI.a(this.ntR.ntQ, this.ntS, 1);
        } catch (Exception e) {
            x.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[]{e.getMessage()});
            this.ntR.ntQ.finish();
        }
    }
}
