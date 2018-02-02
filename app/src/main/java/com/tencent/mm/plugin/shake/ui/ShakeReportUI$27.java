package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeReportUI$27 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$27(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ShakeReportUI.a(this.qsi, false);
        this.qsi.finish();
        return true;
    }
}
