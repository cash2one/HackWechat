package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanMsgUI lhT;

    CleanMsgUI$1(CleanMsgUI cleanMsgUI) {
        this.lhT = cleanMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lhT.finish();
        return false;
    }
}
