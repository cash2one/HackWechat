package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.plugin.game.model.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class GameRouteUI$1 implements a {
    final /* synthetic */ GameRouteUI nwH;

    GameRouteUI$1(GameRouteUI gameRouteUI) {
        this.nwH = gameRouteUI;
    }

    public final void b(bp bpVar) {
        if (bpVar == null || bh.cA(bpVar.ngS)) {
            x.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
            GameRouteUI.a(this.nwH);
            return;
        }
        GameRouteUI.a(this.nwH, bpVar.ngS);
    }
}
