package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5;
import com.tencent.mm.sdk.platformtools.x;

class GameDownloadGuidanceUI$5$1 implements Runnable {
    final /* synthetic */ ah npK;
    final /* synthetic */ 5 npL;

    GameDownloadGuidanceUI$5$1(5 5, ah ahVar) {
        this.npL = 5;
        this.npK = ahVar;
    }

    public final void run() {
        try {
            this.npL.npI.a(this.npK, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[]{e.getMessage()});
            this.npL.npI.finish();
        }
        if (GameDownloadGuidanceUI.a(this.npL.npI) != null) {
            GameDownloadGuidanceUI.a(this.npL.npI).dismiss();
        }
        x.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.npL.gyu)});
    }
}
