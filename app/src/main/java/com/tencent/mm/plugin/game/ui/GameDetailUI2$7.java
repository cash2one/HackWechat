package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.dt;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;

class GameDetailUI2$7 implements p$c {
    final /* synthetic */ dt npA;
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$7(GameDetailUI2 gameDetailUI2, dt dtVar) {
        this.npz = gameDetailUI2;
        this.npA = dtVar;
    }

    public final void a(n nVar) {
        if (this.npA.nkj) {
            nVar.a(0, this.npz.getString(R.l.eYd), R.k.dwQ);
        }
        if (this.npA.nkk) {
            nVar.a(1, this.npz.getString(R.l.eYe), R.k.dwF);
        }
    }
}
