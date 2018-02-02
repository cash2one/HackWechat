package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class UnfamiliarContactDetailUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$5(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qma.finish();
        return true;
    }
}
