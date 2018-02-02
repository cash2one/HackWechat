package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.bc;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;

class GameOverSeaCenterUI$2 implements Runnable {
    final /* synthetic */ GameOverSeaCenterUI ntQ;

    GameOverSeaCenterUI$2(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.ntQ = gameOverSeaCenterUI;
    }

    public final void run() {
        byte[] BX = SubCoreGameCenter.aRh().BX("pb_over_sea");
        if (BX == null) {
            ag.y(new 1(this));
        } else {
            ag.y(new 2(this, new am(BX)));
        }
        SubCoreGameCenter.aRj().init(this.ntQ);
        c.T(g.aPX());
        ag.y(new Runnable(this) {
            final /* synthetic */ GameOverSeaCenterUI$2 ntR;

            {
                this.ntR = r1;
            }

            public final void run() {
                GameOverSeaCenterUI.b(this.ntR.ntQ).eJ(true);
            }
        });
        ar.CG().a(new bc(w.cfi(), g.aPX(), this.ntQ.nmw, this.ntQ.nmx, this.ntQ.nmy, this.ntQ.nmv), 0);
        g.aPZ();
        a.aRT().aRR();
    }
}
