package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GestureGuardLogicUI$16 implements OnClickListener {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$16(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.tgm.onClick(GestureGuardLogicUI.l(this.tgm)[GestureGuardLogicUI.m(this.tgm)].tgv);
    }
}
