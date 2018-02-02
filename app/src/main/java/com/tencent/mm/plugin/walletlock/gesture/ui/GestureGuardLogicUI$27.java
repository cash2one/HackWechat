package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;

class GestureGuardLogicUI$27 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;
    final /* synthetic */ a tgq;

    GestureGuardLogicUI$27(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.tgm = gestureGuardLogicUI;
        this.tgq = aVar;
    }

    public final void onDone() {
        GestureGuardLogicUI.a(this.tgm, 0);
        this.tgq.tgu.bOe();
        this.tgq.tgu.tgK = true;
    }
}
