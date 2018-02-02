package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

class GestureGuardLogicUI$2 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;
    final /* synthetic */ PatternLockView tgn;

    GestureGuardLogicUI$2(GestureGuardLogicUI gestureGuardLogicUI, PatternLockView patternLockView) {
        this.tgm = gestureGuardLogicUI;
        this.tgn = patternLockView;
    }

    public final void onDone() {
        this.tgn.bOe();
        this.tgn.tgK = true;
    }
}
