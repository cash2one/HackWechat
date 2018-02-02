package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.sdk.platformtools.ag;

class GameDownloadGuidanceUI$5 implements Runnable {
    final /* synthetic */ long gyu;
    final /* synthetic */ a nni;
    final /* synthetic */ GameDownloadGuidanceUI npI;

    GameDownloadGuidanceUI$5(GameDownloadGuidanceUI gameDownloadGuidanceUI, a aVar, long j) {
        this.npI = gameDownloadGuidanceUI;
        this.nni = aVar;
        this.gyu = j;
    }

    public final void run() {
        if (this.nni == null) {
            GameDownloadGuidanceUI.a(this.npI, new br());
        } else {
            GameDownloadGuidanceUI.a(this.npI, (br) this.nni);
        }
        ag.y(new 1(this, new ah(this.nni)));
    }
}
