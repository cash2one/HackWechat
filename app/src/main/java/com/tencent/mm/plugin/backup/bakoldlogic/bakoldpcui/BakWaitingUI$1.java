package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakWaitingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakWaitingUI kse;

    BakWaitingUI$1(BakWaitingUI bakWaitingUI) {
        this.kse = bakWaitingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BakWaitingUI.a(this.kse);
        return true;
    }
}
