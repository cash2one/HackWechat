package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingDetailUI lhN;

    CleanChattingDetailUI$1(CleanChattingDetailUI cleanChattingDetailUI) {
        this.lhN = cleanChattingDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lhN.finish();
        return false;
    }
}
