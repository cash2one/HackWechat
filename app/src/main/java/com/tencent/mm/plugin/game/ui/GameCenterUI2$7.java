package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.az;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class GameCenterUI2$7 implements Runnable {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$7(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void run() {
        byte[] BX = SubCoreGameCenter.aRh().BX("pb_index_2");
        if (BX == null) {
            ag.y(new Runnable(this) {
                final /* synthetic */ GameCenterUI2$7 nnl;

                {
                    this.nnl = r1;
                }

                public final void run() {
                    if (!this.nnl.nnh.isFinishing()) {
                        GameCenterUI2.a(this.nnl.nnh, c.cR(this.nnl.nnh));
                        GameCenterUI2.i(this.nnl.nnh).show();
                    }
                }
            });
        } else {
            final ai aiVar = new ai(BX);
            ag.y(new Runnable(this) {
                final /* synthetic */ GameCenterUI2$7 nnl;

                public final void run() {
                    try {
                        GameCenterUI2.a(this.nnl.nnh, aiVar, 1);
                    } catch (Exception e) {
                        x.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
                        this.nnl.nnh.finish();
                    }
                }
            });
        }
        SubCoreGameCenter.aRj().init(this.nnh);
        c.T(g.aPX());
        ag.y(new 3(this));
        ar.CG().a(new az(w.cfi(), g.aPX(), GameCenterUI2.k(this.nnh), GameCenterUI2.l(this.nnh), GameCenterUI2.m(this.nnh), GameCenterUI2.b(this.nnh)), 0);
        g.cL(this.nnh.mController.xIM);
        g.aPZ();
        a$a.nwW.aRR();
    }
}
