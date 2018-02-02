package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ComposeUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$5(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ComposeUI.l(this.prr).onClick(null);
        return false;
    }
}
