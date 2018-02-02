package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.bn;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.ag;

class GameCenterUI5$2 implements Runnable {
    final /* synthetic */ long gyu;
    final /* synthetic */ a nni;
    final /* synthetic */ GameCenterUI5 nnu;

    GameCenterUI5$2(GameCenterUI5 gameCenterUI5, a aVar, long j) {
        this.nnu = gameCenterUI5;
        this.nni = aVar;
        this.gyu = j;
    }

    public final void run() {
        bn bnVar;
        if (this.nni == null) {
            bnVar = new bn();
        } else {
            bnVar = (bn) this.nni;
            SubCoreGameCenter.aRh().a("pb_index_4", bnVar);
        }
        ag.y(new 1(this, new aj(bnVar)));
    }
}
