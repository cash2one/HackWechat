package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;

class GameDownloadGuidanceUI$3 implements Runnable {
    final /* synthetic */ GameDownloadGuidanceUI npI;

    GameDownloadGuidanceUI$3(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.npI = gameDownloadGuidanceUI;
    }

    public final void run() {
        SubCoreGameCenter.aRh().a("pb_over_sea", GameDownloadGuidanceUI.b(this.npI));
    }
}
