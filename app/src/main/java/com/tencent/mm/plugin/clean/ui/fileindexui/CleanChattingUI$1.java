package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$1(CleanChattingUI cleanChattingUI) {
        this.lgN = cleanChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lgN.finish();
        return false;
    }
}
