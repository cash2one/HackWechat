package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GestureGuardLogicUI$20 implements OnClickListener {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$20(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        GestureGuardLogicUI.r(this.tgm);
        GestureGuardLogicUI.a(this.tgm, 0, 4, "user cancel when setting gesture");
    }
}
