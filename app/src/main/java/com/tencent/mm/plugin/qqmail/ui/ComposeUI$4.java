package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ComposeUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$4(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ComposeUI.k(this.prr).onClick(null);
        return false;
    }
}
