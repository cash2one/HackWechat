package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeReportUI$28 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$28(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ShakeReportUI.a(this.qsi, false);
        Intent intent = new Intent();
        intent.setClass(this.qsi, ShakePersonalInfoUI.class);
        this.qsi.startActivityForResult(intent, 3);
        return true;
    }
}
