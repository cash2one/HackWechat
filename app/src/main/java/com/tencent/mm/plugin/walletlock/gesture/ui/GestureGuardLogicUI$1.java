package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GestureGuardLogicUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$1(GestureGuardLogicUI gestureGuardLogicUI) {
        this.tgm = gestureGuardLogicUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!GestureGuardLogicUI.a(this.tgm)) {
            GestureGuardLogicUI.a(this.tgm, 0, 4, "user cancel when setting gesture");
        }
        return true;
    }
}
