package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeItemListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeItemListUI qqB;

    ShakeItemListUI$5(ShakeItemListUI shakeItemListUI) {
        this.qqB = shakeItemListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qqB.aWs();
        this.qqB.finish();
        return true;
    }
}
