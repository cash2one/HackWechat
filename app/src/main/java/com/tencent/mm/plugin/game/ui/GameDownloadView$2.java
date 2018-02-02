package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ac;

class GameDownloadView$2 implements Runnable {
    final /* synthetic */ GameDownloadView npP;

    GameDownloadView$2(GameDownloadView gameDownloadView) {
        this.npP = gameDownloadView;
    }

    public final void run() {
        GameDownloadView.b(this.npP).cP(ac.getContext());
        GameDownloadView.b(this.npP).aQj();
        GameDownloadView.a(this.npP);
    }
}
