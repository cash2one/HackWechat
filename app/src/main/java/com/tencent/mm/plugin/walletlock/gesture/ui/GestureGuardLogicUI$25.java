package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;

class GestureGuardLogicUI$25 implements a {
    final /* synthetic */ GestureGuardLogicUI tgm;
    final /* synthetic */ a tgq;

    GestureGuardLogicUI$25(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.tgm = gestureGuardLogicUI;
        this.tgq = aVar;
    }

    public final void onDone() {
        GestureGuardLogicUI.f(this.tgm).postDelayed(new Runnable(this) {
            final /* synthetic */ GestureGuardLogicUI$25 tgr;

            {
                this.tgr = r1;
            }

            public final void run() {
                GestureGuardLogicUI.f(this.tgr.tgm).removeCallbacks(this);
                this.tgr.tgq.tgu.bOe();
                GestureGuardLogicUI.a(this.tgr.tgm, 16);
                GestureGuardLogicUI.g(this.tgr.tgm);
                GestureGuardLogicUI.h(this.tgr.tgm);
            }
        }, 500);
    }
}
