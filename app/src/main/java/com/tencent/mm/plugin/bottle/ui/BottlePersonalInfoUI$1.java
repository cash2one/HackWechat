package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottlePersonalInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BottlePersonalInfoUI kCn;

    BottlePersonalInfoUI$1(BottlePersonalInfoUI bottlePersonalInfoUI) {
        this.kCn = bottlePersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kCn.finish();
        return true;
    }
}
