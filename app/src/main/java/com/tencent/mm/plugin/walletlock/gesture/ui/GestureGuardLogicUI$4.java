package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class GestureGuardLogicUI$4 implements OnCancelListener {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$4(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GestureGuardLogicUI.l(this.tgm)[GestureGuardLogicUI.m(this.tgm)].tgu.bOe();
        if (GestureGuardLogicUI.n(this.tgm) != null && !GestureGuardLogicUI.n(this.tgm).aBT) {
            g.CG().c(GestureGuardLogicUI.n(this.tgm));
        }
    }
}
