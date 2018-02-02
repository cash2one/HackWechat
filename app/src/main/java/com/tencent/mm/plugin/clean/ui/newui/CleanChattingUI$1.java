package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingUI lhQ;

    CleanChattingUI$1(CleanChattingUI cleanChattingUI) {
        this.lhQ = cleanChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lhQ.finish();
        return false;
    }
}
