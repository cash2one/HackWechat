package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceLikeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceLikeUI lUB;

    ExdeviceLikeUI$2(ExdeviceLikeUI exdeviceLikeUI) {
        this.lUB = exdeviceLikeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lUB.finish();
        return false;
    }
}
