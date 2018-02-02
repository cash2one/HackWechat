package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2;

class GameDownloadGuidanceUI$2$1 implements Runnable {
    final /* synthetic */ 2 npJ;

    GameDownloadGuidanceUI$2$1(2 2) {
        this.npJ = 2;
    }

    public final void run() {
        if (!this.npJ.npI.isFinishing()) {
            GameDownloadGuidanceUI.a(this.npJ.npI, c.cR(this.npJ.npI));
            GameDownloadGuidanceUI.a(this.npJ.npI).show();
        }
    }
}
