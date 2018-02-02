package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakePersonalInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakePersonalInfoUI qqS;

    ShakePersonalInfoUI$1(ShakePersonalInfoUI shakePersonalInfoUI) {
        this.qqS = shakePersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qqS.finish();
        return true;
    }
}
