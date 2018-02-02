package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.h;

class GameDetailUI2$9 implements a {
    final /* synthetic */ String fhl;
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$9(GameDetailUI2 gameDetailUI2, String str) {
        this.npz = gameDetailUI2;
        this.fhl = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            GameDetailUI2.a(this.npz, this.fhl, str);
            h.bu(this.npz, this.npz.getResources().getString(R.l.dUd));
            ap.a(this.npz.mController.xIM, 12, 1207, 2, 14, GameDetailUI2.f(this.npz), GameDetailUI2.g(this.npz), null);
        }
    }
}
