package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class TVInfoUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ TVInfoUI qsE;

    TVInfoUI$4(TVInfoUI tVInfoUI) {
        this.qsE = tVInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qsE.finish();
        return true;
    }
}
