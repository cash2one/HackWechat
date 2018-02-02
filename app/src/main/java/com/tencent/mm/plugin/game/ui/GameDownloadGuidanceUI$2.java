package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.model.bb;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;

class GameDownloadGuidanceUI$2 implements Runnable {
    final /* synthetic */ GameDownloadGuidanceUI npI;

    GameDownloadGuidanceUI$2(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.npI = gameDownloadGuidanceUI;
    }

    public final void run() {
        byte[] BX = SubCoreGameCenter.aRh().BX("pb_download_guidance");
        if (BX == null) {
            ag.y(new 1(this));
        } else {
            ag.y(new 2(this, new ah(BX)));
        }
        ar.CG().a(new bb(w.cfi(), g.aPX(), this.npI.nmw, this.npI.nmx, this.npI.nmy, this.npI.nmv), 0);
        g.aPZ();
        a.aRT().aRR();
    }
}
