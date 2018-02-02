package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2;
import com.tencent.mm.sdk.platformtools.x;

class GameDownloadGuidanceUI$2$2 implements Runnable {
    final /* synthetic */ 2 npJ;
    final /* synthetic */ ah npK;

    GameDownloadGuidanceUI$2$2(2 2, ah ahVar) {
        this.npJ = 2;
        this.npK = ahVar;
    }

    public final void run() {
        try {
            this.npJ.npI.a(this.npK, 1);
        } catch (Exception e) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[]{e.getMessage()});
            this.npJ.npI.finish();
        }
    }
}
