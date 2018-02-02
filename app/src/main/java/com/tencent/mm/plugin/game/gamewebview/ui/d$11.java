package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

class d$11 implements a {
    final /* synthetic */ d mZC;

    d$11(d dVar) {
        this.mZC = dVar;
    }

    public final void qI(int i) {
        x.i("MicroMsg.GameWebPageView", "onKeyBoardStateChange, state = " + i);
        d.a(this.mZC, d.H(this.mZC), i);
        if (i == -3 && d.E(this.mZC) != null && d.E(this.mZC).getVisibility() == 0) {
            d.E(this.mZC).bUV();
        }
    }
}
