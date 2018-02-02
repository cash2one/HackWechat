package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanNewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanNewUI lhX;

    CleanNewUI$1(CleanNewUI cleanNewUI) {
        this.lhX = cleanNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lhX.finish();
        return false;
    }
}
