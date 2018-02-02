package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.n$b;

class GameInstalledView$2 implements n$b {
    final /* synthetic */ GameInstalledView nsa;

    GameInstalledView$2(GameInstalledView gameInstalledView) {
        this.nsa = gameInstalledView;
    }

    public final void h(int i, String str, boolean z) {
        switch (i) {
            case 3:
                SubCoreGameCenter.aRj().init(GameInstalledView.d(this.nsa));
                this.nsa.eJ(false);
                return;
            default:
                return;
        }
    }
}
