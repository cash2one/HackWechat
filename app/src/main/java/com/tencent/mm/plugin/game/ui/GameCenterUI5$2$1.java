package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.ui.GameCenterUI5.2;
import com.tencent.mm.sdk.platformtools.x;

class GameCenterUI5$2$1 implements Runnable {
    final /* synthetic */ aj nnv;
    final /* synthetic */ 2 nnw;

    GameCenterUI5$2$1(2 2, aj ajVar) {
        this.nnw = 2;
        this.nnv = ajVar;
    }

    public final void run() {
        try {
            GameCenterUI5.a(this.nnw.nnu, this.nnv, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", e.getMessage());
            this.nnw.nnu.finish();
        }
        if (GameCenterUI5.a(this.nnw.nnu) != null) {
            GameCenterUI5.a(this.nnw.nnu).dismiss();
        }
        x.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - this.nnw.gyu));
    }
}
