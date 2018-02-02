package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.sdk.platformtools.ag;

class GameDetailUI2$14 implements Runnable {
    final /* synthetic */ a nni;
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$14(GameDetailUI2 gameDetailUI2, a aVar) {
        this.npz = gameDetailUI2;
        this.nni = aVar;
    }

    public final void run() {
        ag.y(new 1(this, new af(this.nni)));
    }
}
