package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingDetailUI lgF;

    CleanChattingDetailUI$1(CleanChattingDetailUI cleanChattingDetailUI) {
        this.lgF = cleanChattingDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lgF.finish();
        return false;
    }
}
