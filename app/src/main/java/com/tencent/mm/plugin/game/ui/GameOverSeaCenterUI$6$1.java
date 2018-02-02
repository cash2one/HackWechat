package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.6;
import com.tencent.mm.sdk.platformtools.x;

class GameOverSeaCenterUI$6$1 implements Runnable {
    final /* synthetic */ am ntS;
    final /* synthetic */ 6 ntT;

    GameOverSeaCenterUI$6$1(6 6, am amVar) {
        this.ntT = 6;
        this.ntS = amVar;
    }

    public final void run() {
        try {
            GameOverSeaCenterUI.a(this.ntT.ntQ, this.ntS, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[]{e.getMessage()});
            this.ntT.ntQ.finish();
        }
        if (GameOverSeaCenterUI.a(this.ntT.ntQ) != null) {
            GameOverSeaCenterUI.a(this.ntT.ntQ).dismiss();
        }
        x.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.ntT.gyu)});
    }
}
