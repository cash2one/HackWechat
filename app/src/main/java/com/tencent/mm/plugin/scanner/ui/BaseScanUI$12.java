package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseScanUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$12(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BaseScanUI.i(this.pUR);
        return false;
    }
}
