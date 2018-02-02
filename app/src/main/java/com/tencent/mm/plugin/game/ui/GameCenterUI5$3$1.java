package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.ui.GameCenterUI5.3;

class GameCenterUI5$3$1 implements Runnable {
    final /* synthetic */ 3 nnx;

    GameCenterUI5$3$1(3 3) {
        this.nnx = 3;
    }

    public final void run() {
        if (!this.nnx.nnu.isFinishing()) {
            GameCenterUI5.a(this.nnx.nnu, c.cR(this.nnx.nnu));
            GameCenterUI5.a(this.nnx.nnu).show();
        }
    }
}
