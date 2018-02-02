package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanMsgUI lhh;

    CleanMsgUI$1(CleanMsgUI cleanMsgUI) {
        this.lhh = cleanMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lhh.finish();
        return false;
    }
}
