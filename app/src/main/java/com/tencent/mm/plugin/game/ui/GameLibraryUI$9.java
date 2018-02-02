package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.sdk.platformtools.ag;

class GameLibraryUI$9 implements Runnable {
    final /* synthetic */ a nni;
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$9(GameLibraryUI gameLibraryUI, a aVar) {
        this.nsw = gameLibraryUI;
        this.nni = aVar;
    }

    public final void run() {
        a aVar = this.nni;
        boolean z = GameLibraryUI.m(this.nsw) == 0 && !GameLibraryUI.n(this.nsw);
        al alVar = new al(aVar, z, GameLibraryUI.m(this.nsw));
        GameLibraryUI.o(this.nsw);
        ag.y(new 1(this, alVar));
    }
}
